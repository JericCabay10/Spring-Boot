package com.example.u_pay.utils;

public class RoleGenerators {
    public static String rolePick() {
        boolean defaultRole = true;
        String role = "";

        if(defaultRole) {
            role = "User";
        }else {
            role = "Admin";
        }
        return role;
    }
}
