package com.platform.demosecurityv2;

import com.platform.demosecurityv2.entity.UserEntity;
import com.platform.demosecurityv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class Demosecurityv2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Demosecurityv2Application.class, args);
    }

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findByUsername("nando").isEmpty()){
            UserEntity user = UserEntity.builder()
                .username("nando")
                .password(encoder.encode("123"))
                .enabled(true)
                .roles(Arrays.asList("ADMIN"))
                .build();
            userRepository.save(user);
        }
    }
}
