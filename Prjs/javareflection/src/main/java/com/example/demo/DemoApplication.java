package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Field;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public void run(){
        System.out.println("Start run()");

        Users user = new Users();
        for (Field field : Users.class.getDeclaredFields()){
            try {
                field.set(user, 1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(user);

        user.setId(1);
        user.setUser_name("User");
        System.out.println(user);

        System.out.println("End run()");
    }
}
