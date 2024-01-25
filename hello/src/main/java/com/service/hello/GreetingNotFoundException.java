package com.service.hello;

class GreetingNotFoundException extends RuntimeException {

    GreetingNotFoundException(Long id) {
        super("Could not find greeting " + id);
    }
}