package br.com.pzg.project.two.handlers;

import br.com.pzg.project.two.domain.Person;
import br.com.pzg.project.two.domain.Search;
import br.com.pzg.project.two.persistence.PeopleDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {
    private final PeopleDataService dataSvc;

    public PersonHandler(PeopleDataService pSvc) {
        this.dataSvc = pSvc;
    }

    public Mono<ServerResponse> getPeoples(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(this.dataSvc.findAll(), Person.class);
    }

    public Mono<ServerResponse> addPerson(ServerRequest request){
        Mono<Person> p = request.bodyToMono(Person.class);
        this.dataSvc.addPerson(p.block());
        return ServerResponse.accepted().contentType(MediaType.APPLICATION_JSON)
                .body(p,Person.class);
    }

    public Mono<ServerResponse> getPersonByEmail(ServerRequest request){
        Mono<Search> searchMono = request.bodyToMono(Search.class);
        return ServerResponse.status(HttpStatus.FOUND).contentType(MediaType.APPLICATION_JSON)
                .body(this.dataSvc.findByEmailAddress(searchMono.block().getTerm())
                ,Person.class);
    }

    public Mono<ServerResponse> getPersonByPhone(ServerRequest request){
        Mono<Search> searchMono = request.bodyToMono(Search.class);
        return ServerResponse.status(HttpStatus.FOUND).contentType(MediaType.APPLICATION_JSON)
                .body(this.dataSvc.findByPhone(searchMono.block().getTerm())
                        ,Person.class);
    }
}
