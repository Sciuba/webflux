package com.example.demo.repository;

import com.example.demo.document.Games;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GamesRepository extends ReactiveMongoRepository<Games, String> {
}
