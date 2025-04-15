package com.samdi2.enemy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FightService {
    private final EnemyRepository enemyRepository;

    public void createEnemy() {
        Enemy enemy = Enemy.builder()
                .name("뽀삐")
                .health(10)
                .damage(5000)
                .weapon("개껌")
                .skill("꼬리흔들기")
                .build();

        enemyRepository.save(enemy);
    }

    public int attack() {
        Enemy bobby = enemyRepository.findById(1L).orElse(null);

        if (bobby.getHealth() <= 0) {
            throw new RuntimeException("체력이 없습니다.");
        }

        bobby.setHealth(bobby.getHealth() -1);

        enemyRepository.save(bobby);

        return bobby.getHealth();
    }
}
