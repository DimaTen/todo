package com.dmitrij.javaenterprise.todo.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private long userId;
    @NotBlank
    private String firstName;
    private String lastName;
    private String password;
    private String matchingPassword;
    private String email;
    private String userRole;


}
