package com.nuline.ms.admin.models.enums;

public enum UserRole{
    READ,
    ROLE_ADMIN;

    public static boolean hasRole(String role) {
        for(UserRole r : UserRole.values()){
            if(role.equals(r.name())){
                return true;
            }
        }
        return false;
    }
}