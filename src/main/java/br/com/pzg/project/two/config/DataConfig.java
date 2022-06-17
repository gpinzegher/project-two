package br.com.pzg.project.two.config;

import br.com.pzg.project.two.domain.CompanyEvent;
import br.com.pzg.project.two.domain.Course;
import br.com.pzg.project.two.domain.CourseCache;
import br.com.pzg.project.two.domain.Person;
import br.com.pzg.project.two.persistence.FauxCompanyEventsImpl;
import br.com.pzg.project.two.persistence.FauxDataService;
import br.com.pzg.project.two.persistence.FauxPeoplesServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Configuration
public class DataConfig {

    private final ObjectMapper mapper;
    Logger log = LoggerFactory.getLogger(DataConfig.class);
    @Autowired
    private ApplicationContext ctx;

    public DataConfig() {
        mapper = new ObjectMapper();
    }

    private List readJsonData(String fileName, TypeReference<?> valueRef) throws IOException {
        return (List) mapper.readValue(Files.newInputStream(ctx.getResource(fileName).getFile().toPath()),valueRef);
    }

    @Bean("cacheJson")
    public CourseCache initializeFauxRepository(FauxDataService dataSvc, @Value("${data.file.courses.cache}") String fileName) throws IOException {
        List<Course> crsList = readJsonData(fileName, new TypeReference<List<Course>>() { });
        dataSvc.saveAll(crsList);
        return CourseCache.builder().parsedCourses(crsList).build();
    }

    @Bean("loadJson")
    public CommandLineRunner initialFauxDataSvc(FauxDataService dataSvc, @Value("${data.file.courses}") String fileName) {
        return args -> {
            List<Course> crsList = null;
            try {
                crsList = readJsonData(fileName, new TypeReference<List<Course>>() { });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dataSvc.saveAll(crsList);
        };
    }



    @Bean("loadevents")
    public CommandLineRunner initializeFunctionalDataEntities(
            @Value("${data.file.events.cache}") String eventsJson,
            @Value("${data.file.person.cache}") String peepsJson,
            FauxCompanyEventsImpl eventsSvc, FauxPeoplesServiceImpl peopleSvc)
    {
        return args -> {
            List<CompanyEvent> events = null;
            List<Person> peoples = null;
            events = readJsonData(eventsJson, new TypeReference<List<CompanyEvent>>() { });
            peoples = readJsonData(peepsJson, new TypeReference<List<Person>>() { });

            int a = 0;
            int b = 3;
            for (CompanyEvent e : events) {
                e.setAttendees(peoples.subList(a,b));
                a+=3; b+=3;
            }

            eventsSvc.addEvents(events);
            peopleSvc.addGroup(peoples);

        };
    }
}