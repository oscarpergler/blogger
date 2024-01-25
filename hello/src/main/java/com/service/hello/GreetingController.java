package com.service.hello;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {

    private final GreetingRepository repository;

    GreetingController(GreetingRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/greetings")
    List<Greeting> all() {
        return repository.findAll();
    }

    @PostMapping("/greetings")
    Greeting newGreeting(@RequestBody Greeting newGreeting) {
        return repository.save(newGreeting);
    }

    @GetMapping("/greetings/{id}")
    Greeting one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new GreetingNotFoundException(id));
    }

    @PutMapping("/greetings/{id}")
    Greeting replaceGreeting(@RequestBody Greeting newGreeting, @PathVariable Long id) {

        return repository.findById(id)
                .map(greeting -> {
                    greeting.setMessage(newGreeting.getMessage());
                    greeting.setTone(newGreeting.getTone());
                    return repository.save(greeting);
                })
                .orElseGet(() -> {
                    newGreeting.setId(id);
                    return repository.save(newGreeting);
                });
    }

    @DeleteMapping("/greetings/{id}")
    void deleteGreeting(@PathVariable Long id) {
        repository.deleteById(id);
    }
}