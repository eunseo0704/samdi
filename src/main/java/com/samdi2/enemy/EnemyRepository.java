package com.samdi2.enemy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnemyRepository extends JpaRepository<Enemy, Long> {
    Optional<Enemy> findByName(String name);
}
