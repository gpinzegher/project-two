package br.com.pzg.project.two.service.inter;

import br.com.pzg.project.two.domain.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CourseService {

    public Mono<Course> getCourse(UUID id);
    public Flux<Course> getAllCoursesFromAuthor(UUID authorId);
}
