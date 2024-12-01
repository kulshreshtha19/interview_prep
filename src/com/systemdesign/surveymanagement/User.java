package com.systemdesign.surveymanagement;

public class User {

    String name;

    String email;

    UserRole userRole;

    User(String name, String email, UserRole userRole) {
        this.name = name;
        this.email = email;
        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return this.userRole;
    }
}
