package br.com.pzg.project.two.service.impl;

import br.com.pzg.project.two.domain.Course;
import br.com.pzg.project.two.persistence.CourseDataService;
import br.com.pzg.project.two.repository.CourseRepository;
import br.com.pzg.project.two.service.inter.CourseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseDataService crsData;

    public CourseServiceImpl(CourseDataService crsData) {
        this.crsData = crsData;
    }

    @Override
    public Flux<Course> getCurrentCourses() {
        return this.crsData.findAll();
    }

    @Override
    public Mono<Course> findCourseByTitle(String title) {
        if (title.contains("svcfaux")){
            throw new IllegalArgumentException("illegal title characters");
        }
        return crsData.findCourseByTitle(title);
    }

    @Override
    public void save(Course nueCourse) {
        this.crsData.save(nueCourse);
    }

    @Override
    public void saveAll(List<Course> nueCourses) {
        this.crsData.saveAll(nueCourses);
    }

    @Override
    public Flux<Course> findCoursesByTitleContaining(String phrase) {
        return this.crsData.findCourseByTitleContianing(phrase);
    }
}
