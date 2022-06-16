package br.com.pzg.project.two.controller;

import br.com.pzg.project.two.domain.Author;
import br.com.pzg.project.two.domain.Course;
import br.com.pzg.project.two.service.inter.AuthorService;
import br.com.pzg.project.two.service.inter.CourseService;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping(path = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
    private final CourseService crsCatalog;

    public CourseController(CourseService crsCatalog) {
        this.crsCatalog = crsCatalog;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Course> getCurrentCourses(){
        return this.crsCatalog.getCurrentCourses();
    }


    @GetMapping(path="nd-stream",produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Course> getCurrentCoursesNDStream(){
        return this.crsCatalog.getCurrentCourses();
    }

    @GetMapping(path="txt-stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent> getCurrentCoursesStream(){
        return this.crsCatalog.getCurrentCourses()
                .map(c -> ServerSentEvent.builder()
                        .id(UUID.randomUUID().toString())
                        .event(String.valueOf(Instant.now().getEpochSecond()))
                        .data(c)
                        .build());
    }

    @GetMapping(path = "{crsTitle:[\\w-]{3,30}}")
    public Mono<Course> findCourseByTitle(@PathVariable("crsTitle") String title){
        return this.crsCatalog.findCourseByTitle(title);
    }
}
