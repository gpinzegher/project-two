package br.com.pzg.project.two.persistence;

import br.com.pzg.project.two.domain.Author;
import br.com.pzg.project.two.domain.Course;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FauxDataService {

    public List<Course> courses;
    public List<Author> authors;

    public Flux<Author> aut;

    public FauxDataService(){

        Author a1 = Author.builder().id(UUID.randomUUID()).firstName("FirsName1").lastName("LastName1").build();
        Author a2 = Author.builder().id(UUID.randomUUID()).firstName("FirsName2").lastName("LastName2").build();

        Course c1 = Course.builder().id(UUID.randomUUID()).author(a1).name("Course1").build();
        Course c2 = Course.builder().id(UUID.randomUUID()).author(a1).name("Course2").build();
        Course c3 = Course.builder().id(UUID.randomUUID()).author(a2).name("Course3").build();

        this.courses = Arrays.asList(c1, c2, c3);
        this.authors = Arrays.asList(a1, a2);
    }
}
