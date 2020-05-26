package com.example.demo.service;

import com.example.demo.document.Games;
import com.example.demo.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GamesService {

    @Autowired
    private GamesRepository gamesRepository;

    public Flux<Games> findAll(){
        return gamesRepository.findAll();
    }

    public Mono<Games> findById(String id){
        return gamesRepository.findById(id);
    }

    public Mono<Games> save(Games game){
        return gamesRepository.save(game);
    }

}
