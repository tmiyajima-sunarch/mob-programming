package com.example.mob.programming.passwordgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PasswordGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(PasswordGeneratorApplication.class, args);
    }

    @Controller
    public static class IndexController {
        @GetMapping("/")
        String index() {
            return "index";
        }
    }

    @RestController
    public static class GenerateController {
        private final PasswordGenerator passwordGenerator;

        public GenerateController(PasswordGenerator passwordGenerator) {
            this.passwordGenerator = passwordGenerator;
        }

        @PostMapping("/generate")
        String generate(@RequestBody GenerateInput input) {
            return this.passwordGenerator.generate(input.length(), input.useNumber(), input.useSign());
        }
    }

    public record GenerateInput(Integer length, Boolean useNumber, Boolean useSign) {
    }
}
