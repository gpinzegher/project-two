package br.com.pzg.project.two.persistence;

import br.com.pzg.project.two.domain.Person;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class FauxPeoplesServiceImpl implements PeopleDataService{

    private List<Person> peoples;

    public FauxPeoplesServiceImpl() {
        this.peoples = new ArrayList<>();
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.fromStream(this.peoples.stream());
    }

    @Override
    public Mono<Person> findByEmailAddress(String email) {
        return Mono.justOrEmpty(this.peoples.stream().filter(p->p.getEmailAddress().equalsIgnoreCase(email)).findFirst());
    }

    @Override
    public Mono<Person> findByPhone(String phone) {
        return Mono.justOrEmpty(this.peoples.stream().filter(p->p.getPhone().equalsIgnoreCase(phone)).findFirst());
    }

    @Override
    public void addPerson(Person peep) {
        this.peoples.add(peep);
    }

    @Override
    public void addGroup(List<Person> people) {
        this.peoples.addAll(people);
    }
}
