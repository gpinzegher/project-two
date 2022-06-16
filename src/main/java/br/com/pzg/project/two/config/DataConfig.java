package br.com.pzg.project.two.config;

import br.com.pzg.project.two.persistence.FauxDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    @Bean
    public void initFauxRepo(FauxDataService dataService){

    }
}
