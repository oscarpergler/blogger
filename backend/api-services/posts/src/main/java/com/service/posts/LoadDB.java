package com.service.posts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initDatabase(PostsRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Posts("Vad fan?", "Vem snodde min sko", 1L)));
            log.info("Preloading " + repository.save(new Posts("Lugnt", "Jag hitta den grabbar", 1L)));
            log.info("Preloading " + repository.save(new Posts("Sko säljes", "Ett halvt par skor säljes billigt vid snabb affär", 2L)));
        };
    }
}