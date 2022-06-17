package br.com.pzg.project.two.persistence;

import br.com.pzg.project.two.domain.CompanyEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CorpEventsDataService {

    Flux<CompanyEvent> getCurrentEvents();
    Flux<CompanyEvent> getEventsByLocation(String locale);
    Mono<CompanyEvent> addEvent(CompanyEvent nueEvent);
    void addEvents(List<CompanyEvent> nueEvents);
    Flux<CompanyEvent> getEventsByDuration(int duration);

}
