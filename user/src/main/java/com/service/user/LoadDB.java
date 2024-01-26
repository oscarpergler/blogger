package com.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initDatabase(UsersRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Users("Oscar", "ADMIN", false)));
            log.info("Preloading " + repository.save(new Users("John", "USER", false)));
            log.info("Preloading " + repository.save(new Users("Doe", "USER", true)));
        };
    }
}