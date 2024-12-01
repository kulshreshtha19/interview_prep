package com.systemdesign.surveymanagement;


public class AuthorizationService {

    public boolean validateAdminRole(User user) {
        return user.getUserRole() == UserRole.ADMIN;
    }

    public boolean validateUserRole(User user) {
        return user.getUserRole() == UserRole.USER;
    }


}
