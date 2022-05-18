package com.dmitrij.javaenterprise.todo.repository;

import com.dmitrij.javaenterprise.todo.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
