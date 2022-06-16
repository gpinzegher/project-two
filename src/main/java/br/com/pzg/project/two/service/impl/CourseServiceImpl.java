package br.com.pzg.project.two.service.impl;

import br.com.pzg.project.two.domain.Course;
import br.com.pzg.project.two.service.inter.CourseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class CourseServiceImpl implements CourseService {
    @Override
    public Mono<Course> getCourse(UUID id) {
        return null;
    }

    @Override
    public Flux<Course> getAllCoursesFromAuthor(UUID authorId) {
        return null;
    }
}
