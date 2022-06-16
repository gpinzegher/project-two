package br.com.pzg.project.two.persistence;

import br.com.pzg.project.two.domain.Author;
import br.com.pzg.project.two.domain.Course;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FauxDataService implements CourseDataService{
    private List<Course> crsList;

    public FauxDataService() {
        this.crsList = new ArrayList<>();
    }

    @Override
    public Flux<Course> findAll(){
        return Flux.fromIterable(this.crsList);
    }

    @Override
    public void save(Course nueCourse){
        crsList.add(nueCourse);
    }

    @Override
    public void saveAll(List<Course> nueCourses){
        this.crsList.addAll(nueCourses);
    }

    @Override
    public Flux<Course> findCourseByTitleContianing(String phrase){
        return Flux.fromStream(
                crsList.stream().filter(course -> course.getCatalogTitle().contains(phrase)));
    }

    @Override
    public Mono<Course> findCourseByTitle(String title) {
        return Mono.justOrEmpty(
                crsList.stream().filter(c->c.getCatalogTitle().equalsIgnoreCase(title)).findFirst()
        );
    }
}
