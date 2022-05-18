package com.dmitrij.javaenterprise.todo.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {
    /**
    USER(Sets.newHashSet(
            ApplicationUserPermission.ITEM_READ,
            ApplicationUserPermission.ITEM_WRITE)),
    ADMIN(Sets.newHashSet(
            ApplicationUserPermission.USER_READ,
            ApplicationUserPermission.USER_WRITE));


    private final Set<ApplicationUserPermission> permission;


    ApplicationUserRole(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }

    public Set<ApplicationUserPermission> getPermission() {
        return permission;
    }

    // Boiler plate code - .authorities()
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions =getPermission().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
     **/
}
