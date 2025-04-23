package com.samdi2.enemy;

public record CreateEnemyRequest(
        String name,
        int health,
        int damage,
        String weapon,
        String skill
) {
}