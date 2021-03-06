package br.com.pzg.project.two.repository;

import br.com.pzg.project.two.domain.Author;
import br.com.pzg.project.two.domain.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface CourseRepository{
    Flux<Course> findAll();

    void save(Course nueCourse);

    void saveAll(List<Course> nueCourses);

    Flux<Course> findCourseByTitleContianing(String phrase);
    Mono<Course> findCourseByTitle(String title);
}
