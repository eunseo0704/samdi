package com.samdi2.enemy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FightService {
    private final EnemyRepository enemyRepository; // 의존성 주입

    public void createEnemy(CreateEnemyRequest request) {
        Enemy e = enemyRepository.findByName(request.name()).orElse(null);

        // if 디비에 이미 존재한다면
        if (e != null) {
            throw new IllegalArgumentException(request.name() + "이름의 적이 이미 있습니다.");
        }

        // 디비 인스턴스 생성 방법
        Enemy enemy = Enemy.builder()
                .name(request.name())
                .health(request.health())
                .damage(request.damage())
                .weapon(request.weapon())
                .skill(request.skill())
                .build();

        enemyRepository.save(enemy);
    }

    public int attack() {
        Enemy bbobby = enemyRepository.findById(1L).orElse(null);

        // 체력 깎기 (Setter 사용)
        if (bbobby.getHealth() <= 0) {
            throw new RuntimeException("체력이 없습니다.");
        }

        bbobby.setHealth(bbobby.getHealth() - 1);

        enemyRepository.save(bbobby);

        return bbobby.getHealth();
    }

    public Enemy findEnemyByName(String name) {
        Enemy e = enemyRepository.findByName(name).orElse(null);
        if (e == null) {
            throw new IllegalArgumentException(name + "는 없는 적입니다.");
        }
        return e;
    }
}