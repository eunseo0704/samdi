package com.samdi2.enemy;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fight")
@RequiredArgsConstructor
public class FightController {
    private final FightService fightService;

    @PostMapping()
    public void createEnemy(@RequestBody CreateEnemyRequest request) {
        fightService.createEnemy(request);
    }


    @PatchMapping()
    public int attack() {
        return fightService.attack();
    }
}