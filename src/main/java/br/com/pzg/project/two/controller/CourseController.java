package br.com.pzg.project.two.controller;

import br.com.pzg.project.two.domain.Author;
import br.com.pzg.project.two.domain.Course;
import br.com.pzg.project.two.service.inter.AuthorService;
import br.com.pzg.project.two.service.inter.CourseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/{courseId}")
    public Mono<Course> findCourseById(@PathVariable("courseId") UUID courseId ) {
        return this.service.getCourse(courseId);
    }

    @GetMapping("/all")
    public Flux<Course> findAllAuthors(@PathVariable("authorId") UUID authorId) {
        return this.service.getAllCoursesFromAuthor(authorId);
    }
}
