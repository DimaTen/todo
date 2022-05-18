package com.dmitrij.javaenterprise.todo.controller;

import javax.validation.Valid;

import com.dmitrij.javaenterprise.todo.model.user.Role;
import com.dmitrij.javaenterprise.todo.model.user.User;
import com.dmitrij.javaenterprise.todo.model.user.UserRegistrationDto;
import com.dmitrij.javaenterprise.todo.repository.UserRepository;
import com.dmitrij.javaenterprise.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@Controller
@RequestMapping("/admin")
public class AdminViewController {

    private final UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    public AdminViewController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/adminView")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "adminView";
    }

    @GetMapping("/signup")
    public String showSignUpForm(UserRegistrationDto userDto) {
        return "registration";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                          BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/admin/adminView";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        System.out.println(user);
        return "update-user";
    }

    @PostMapping ("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }
        User newUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", newUser);
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail((user.getEmail()));

        System.out.println(newUser);

        userRepository.save(newUser);


        return "redirect:/admin/adminView";  // TODO fix Change password
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);

        return "redirect:/admin/adminView";
    }
}
