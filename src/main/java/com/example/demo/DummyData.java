package com.example.demo;

import com.example.demo.document.Games;
import com.example.demo.repository.GamesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

/*@Component
public class DummyData implements CommandLineRunner {

    private final GamesRepository gamesRepository;

    DummyData(GamesRepository gamesRepository){
        this.gamesRepository = gamesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        gamesRepository.deleteAll()
                .thenMany(
                        Flux.just("RedDead Redemption 2", "OverWatch", "Diablo3", "The Last Of Us",
                                "Dragon Ball Figther Z")
                .map(name -> new Games(UUID.randomUUID().toString(), name))
                .flatMap(gamesRepository::save))
                .subscribe(System.out::println);

    }
}*/
