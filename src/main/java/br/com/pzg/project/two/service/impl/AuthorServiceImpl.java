package br.com.pzg.project.two.service.impl;

import br.com.pzg.project.two.domain.Author;
import br.com.pzg.project.two.persistence.FauxDataService;
import br.com.pzg.project.two.service.inter.AuthorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class AuthorServiceImpl implements AuthorService {

    private FauxDataService data = new FauxDataService();
    @Override
    public Mono<Author> getAuthor(UUID authorId) {
        return null;
    }

    @Override
    public Flux<Author> getAllAuthors() {
        return null;
    }
}
