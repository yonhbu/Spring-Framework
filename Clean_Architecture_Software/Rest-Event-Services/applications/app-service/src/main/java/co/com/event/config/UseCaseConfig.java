package co.com.event.config;


import co.com.event.jpa.event.EventRepository;
import co.com.event.model.event.gateways.EventGateway;
import co.com.event.usecase.event.EventUseCase;

import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public EventUseCase createMoviesUseCase(EventGateway repository) {
        return new EventUseCase(repository);
    }

    @Bean
    public ObjectMapperImp createObjectMapper() {
        return new ObjectMapperImp();
    }

}

