package com.jcamus.application;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.jcamus.application.entities.User;
import com.jcamus.application.services.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserService userService) {
        return args -> {
            Stream.of("Jean", "Julie", "Jacques", "Joël", "Jeanne").forEach(name -> {
                User user = new User(name, name.substring(name.length() - 1));
                userService.save(user);
            });
            userService.findAll().forEach(System.out::println);
            User user = userService.findById((long) 3);
            User deleted = userService.delete(user.getId());
            System.out.println("deleted = " + deleted);
            userService.findAll().forEach(System.out::println);
            Map<String, List<User>> map = userService.findAllGroupByGroupId();
            System.out.println("map = " + map);
        };
    }
}
