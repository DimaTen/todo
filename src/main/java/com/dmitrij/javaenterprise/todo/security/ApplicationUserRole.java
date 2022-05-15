package com.dmitrij.javaenterprise.todo.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRole {
    USER(Sets.newHashSet(ApplicationUserPermission.USER_READ, ApplicationUserPermission.USER_WRITE)),
    ADMIN(Sets.newHashSet());


    private final Set<ApplicationUserPermission> permission;


    ApplicationUserRole(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }
}
