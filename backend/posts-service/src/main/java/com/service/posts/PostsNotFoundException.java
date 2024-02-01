package com.service.posts;

class PostsNotFoundException extends RuntimeException {

    PostsNotFoundException(Long id) {
        super("Could not find post " + id);
    }
}