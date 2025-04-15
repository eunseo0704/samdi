package com.samdi2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/print")
@RequiredArgsConstructor
public class PrintController {
    private final PrintService printService;

    @GetMapping()
    public String printHelloWorld() { return printService.printHelloWorld(); }
}