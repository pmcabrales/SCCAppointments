package gw.appointment.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // Register JavaTimeModule to handle java.time classes
        mapper.registerModule(new JavaTimeModule());

        // Add custom deserializer for LocalDate map keys
        SimpleModule module = new SimpleModule();
        module.addKeyDeserializer(LocalDate.class, new LocalDateKeyDeserializer());
        mapper.registerModule(module);

        return mapper;
    }
}
