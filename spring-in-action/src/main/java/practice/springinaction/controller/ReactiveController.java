package practice.springinaction.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import practice.springinaction.domain.Taco;
import practice.springinaction.repository.TacoRepository;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ReactiveController {

    private final TacoRepository tacoRepo;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Taco> postTaco(@RequestBody Mono<Taco> tacoMono) {
        return tacoRepo.saveAll(tacoMono).next();
    }
}
