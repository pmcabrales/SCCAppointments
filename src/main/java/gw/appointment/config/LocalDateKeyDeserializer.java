package gw.appointment.config;

import com.fasterxml.jackson.databind.KeyDeserializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateKeyDeserializer extends KeyDeserializer {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public Object deserializeKey(String key, com.fasterxml.jackson.databind.DeserializationContext context) {
        return LocalDate.parse(key, FORMATTER);
    }
}

