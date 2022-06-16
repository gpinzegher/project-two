package br.com.pzg.project.two.service.inter;

import br.com.pzg.project.two.domain.Author;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AuthorService {
    public Mono<Author> getAuthor(UUID authorId);
    public Flux<Author> getAllAuthors();
}
