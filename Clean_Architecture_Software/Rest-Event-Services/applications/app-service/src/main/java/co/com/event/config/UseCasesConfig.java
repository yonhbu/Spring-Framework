package co.com.event.config;

import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import co.com.event.model.event.gateways.EventGateway;
import co.com.event.usecase.event.EventUseCase;

@Configuration
@ComponentScan(basePackages = "co.com.event.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {
	
    @Bean
    public EventUseCase createEventUseCase(EventGateway repository) {
        return new EventUseCase(repository);
    }

    @Bean
    public ObjectMapperImp objectMapper() {
        return new ObjectMapperImp();
    }

}

