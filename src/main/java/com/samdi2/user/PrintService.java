package com.samdi2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrintService {
    private final UserRepository userRepository;

    public String printHelloWorld() {
        User user = User.builder()
                .username("eunseo0704")
                .password("1752")
                .build();
        userRepository.save(user);

        return "Hello World";
    }
}