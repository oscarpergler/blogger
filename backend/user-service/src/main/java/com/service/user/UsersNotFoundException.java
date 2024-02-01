package com.service.user;

class UsersNotFoundException extends RuntimeException {

    UsersNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}