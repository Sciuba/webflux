package com.example.demo;

import com.example.demo.document.Games;

import com.example.demo.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;



import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
public class GamesHandler {

    @Autowired
    private GamesService gamesService;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gamesService.findAll(), Games.class);
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gamesService.findById(id), Games.class);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest){
        final Mono<Games> games = serverRequest.bodyToMono(Games.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(games.flatMap(gamesService::save), Games.class));
    }

}
