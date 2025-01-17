package gw.appointment.config;

import gw.appointment.entity.Appointment;
import gw.appointment.entity.EssentialService;
import gw.appointment.repository.AppointmentRepository;
import gw.appointment.repository.EssentialServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final AppointmentRepository appointmentRepository;
    private final EssentialServiceRepository essentialServiceRepository;

    public DataLoader(AppointmentRepository appointmentRepository, EssentialServiceRepository essentialServiceRepository){
        this.appointmentRepository = appointmentRepository;
        this.essentialServiceRepository = essentialServiceRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        loadAppointments();
        loadEssentialServices();
    }

    private void loadAppointments() {
        appointmentRepository.save(new Appointment(1,LocalDateTime.of(LocalDate.of(2025,1,16), LocalTime.of(12,30)),"Test Appointment"));
    }

    private void loadEssentialServices(){
        essentialServiceRepository.save(new EssentialService(1, "GWCP Observability"));
        essentialServiceRepository.save(new EssentialService(2, "Performance Diagnostics"));
        essentialServiceRepository.save(new EssentialService(3, "Platform Health Review"));
        essentialServiceRepository.save(new EssentialService(4, "Production Transition Enablement"));
    }

    private void loadSkills(){

    }
}
