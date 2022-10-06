package com.example.project1;

import com.example.project1.domain.PostDomain;
import com.example.project1.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Project1Application {

    public static void main(String[] args) {

        SpringApplication.run(Project1Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(PostRepository postRepository) {
        return (args) -> {
            postRepository.save(new PostDomain("title","name","1234","1234"));
            postRepository.save(new PostDomain("title2","name2","12345","12345"));
            postRepository.save(new PostDomain("title3","name3","123456","123456"));

        };
    }
}

