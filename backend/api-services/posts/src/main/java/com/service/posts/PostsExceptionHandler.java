package com.service.posts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PostsExceptionHandler {

    @ResponseBody
    @ExceptionHandler(PostsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String postsNotFoundHandler(PostsNotFoundException ex) {
        return ex.getMessage();
    }
}