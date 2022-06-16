package br.com.pzg.project.two.service.inter;

import br.com.pzg.project.two.domain.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    Flux<Course> getCurrentCourses();
    Mono<Course> findCourseByTitle(String title);
    void save(Course nueCourse);

    void saveAll(List<Course> nueCourses);

    Flux<Course> findCoursesByTitleContaining(String phrase);
}
