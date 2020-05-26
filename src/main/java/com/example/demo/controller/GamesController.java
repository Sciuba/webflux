package com.example.demo.controller;

import com.example.demo.document.Games;
import com.example.demo.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class GamesController {

    @Autowired
    private GamesService gamesService;

    @GetMapping(value = "/games")
    public Flux<Games> findAll(){
        return gamesService.findAll();
    }

    @GetMapping(value = "/games/{id}")
    public Mono<Games> findGame(@PathVariable String id){
        return gamesService.findById(id);
    }

    @PostMapping(value = "/games/add")
    public Mono<Games> save(@RequestBody Games game){
        return gamesService.save(game);
    }

    @GetMapping(value = "/games/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Games>> findAllEvents(){
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Games> events = gamesService.findAll();
        return Flux.zip(interval, events);
    }

}
