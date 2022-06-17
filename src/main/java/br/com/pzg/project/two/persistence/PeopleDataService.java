package br.com.pzg.project.two.persistence;

import br.com.pzg.project.two.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PeopleDataService {
    Flux<Person> findAll();
    Mono<Person> findByEmailAddress(String email);
    Mono<Person> findByPhone(String phone);
    void addPerson(Person peep);
    void addGroup(List<Person> people);

}
