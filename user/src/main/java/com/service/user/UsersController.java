package com.service.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UsersController {

    private final UsersRepository repository;

    UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<Users> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    Users newUsers(@RequestBody Users newUsers) {
        return repository.save(newUsers);
    }

    @GetMapping("/users/{id}")
    Users one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    Users replaceUsers(@RequestBody Users newUsers, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setUsersname(newUsers.getUsersname());
                    user.setRole(newUsers.getRole());
                    user.setVerified(newUsers.getVerified());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUsers.setId(id);
                    return repository.save(newUsers);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUsers(@PathVariable Long id) {
        repository.deleteById(id);
    }
}