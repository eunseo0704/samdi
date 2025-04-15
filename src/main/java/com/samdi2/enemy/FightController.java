package com.samdi2.enemy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FightController {
    private final FightService fightService;

    @PostMapping()
    public void createEnemy() {
        fightService.createEnemy();
    }

    @PatchMapping()
    public int attack() {
        return fightService.attack();
    }
}