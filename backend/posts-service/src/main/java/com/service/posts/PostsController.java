package com.service.posts;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
class PostsController {

    private final PostsRepository repository;

    PostsController(PostsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/posts")
    List<Posts> all() {
        return repository.findAll();
    }

    @PostMapping("/posts")
    Posts newPosts(@RequestBody Posts newPosts) {
        return repository.save(newPosts);
    }

    @GetMapping("/posts/{id}")
    Posts one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PostsNotFoundException(id));
    }

    @PutMapping("/posts/{id}")
    Posts replacePosts(@RequestBody Posts newPosts, @PathVariable Long id) {

        return repository.findById(id)
                .map(post -> {
                    post.setTitle(newPosts.getTitle());
                    post.setText(newPosts.getText());
                    post.setUser(newPosts.getUser());
                    return repository.save(post);
                })
                .orElseGet(() -> {
                    newPosts.setId(id);
                    return repository.save(newPosts);
                });
    }

    @DeleteMapping("/posts/{id}")
    void deletePosts(@PathVariable Long id) {
        repository.deleteById(id);
    }
}