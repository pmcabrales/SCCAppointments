package gw.appointment.config;

import gw.appointment.model.Appointment;
import gw.appointment.dao.AppointmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final AppointmentRepository appointmentRepository;

    public DataLoader(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        appointmentRepository.save(new Appointment(1,LocalDateTime.of(LocalDate.of(2025,1,16), LocalTime.of(12,30)),"Test Appointment"));
    }
}
