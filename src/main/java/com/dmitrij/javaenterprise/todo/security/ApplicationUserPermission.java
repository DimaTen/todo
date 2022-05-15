package com.dmitrij.javaenterprise.todo.security;

public enum ApplicationUserPermission {
    USER_READ("student:read"),
    USER_WRITE("student:write");

    private final String permission;


    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
