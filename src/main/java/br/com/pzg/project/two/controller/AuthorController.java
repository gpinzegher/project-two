package br.com.pzg.project.two.controller;

import br.com.pzg.project.two.domain.Author;
import br.com.pzg.project.two.service.inter.AuthorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/{authorId}")
    public Mono<Author> findAuthorById( @PathVariable("authorId")UUID authorId ) {
        return this.service.getAuthor(authorId);
    }

    @GetMapping("/all")
    public Flux<Author> findAllAuthors() {
        return this.service.getAllAuthors();
    }

}
