package com.service.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initDatabase(GreetingRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Greeting("Hey", "relaxed")));
            log.info("Preloading " + repository.save(new Greeting("Pleased to meet you!", "formal")));
            log.info("Preloading " + repository.save(new Greeting("Our paths cross again...", "mysterious")));
        };
    }
}