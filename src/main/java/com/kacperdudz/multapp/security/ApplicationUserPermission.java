package com.kacperdudz.multapp.security;

public enum ApplicationUserPermission {
    GENERAL_VIEW("general:view"),
    GENERAL_WRITE("general:write"),
    ADMIN_VIEW("admin:view"),
    ADMIN_WRITE("admin:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
