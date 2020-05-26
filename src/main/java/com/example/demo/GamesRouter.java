package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.awt.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class GamesRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GamesHandler handler) {
        return RouterFunctions
                .route(GET("/games").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/games/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/games/add").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }

}
