package gw.appointment.config;

import gw.appointment.entity.Appointment;
import gw.appointment.entity.Skill;
import gw.appointment.repository.AppointmentRepository;
import gw.appointment.repository.ServiceRepository;
import gw.appointment.repository.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final AppointmentRepository appointmentRepository;
    private final ServiceRepository serviceRepository;
    private final SkillRepository skillRepository;

    public DataLoader(AppointmentRepository appointmentRepository, ServiceRepository serviceRepository, SkillRepository skillRepository){
        this.appointmentRepository = appointmentRepository;
        this.serviceRepository = serviceRepository;
        this.skillRepository = skillRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        loadAppointments();
        loadEssentialServices();
        loadSkills();
    }

    private void loadAppointments() {
        appointmentRepository.save(new Appointment(1,LocalDateTime.of(LocalDate.of(2025,1,16), LocalTime.of(12,30)),"Test Appointment"));
    }

    private void loadEssentialServices(){
       /* essentialServiceRepository.save(new EssentialService(1, "GWCP Observability"));
        essentialServiceRepository.save(new EssentialService(2, "Performance Diagnostics"));
        essentialServiceRepository.save(new EssentialService(3, "Platform Health Review"));
        essentialServiceRepository.save(new EssentialService(4, "Production Transition Enablement"));*/
    }

    private void loadSkills(){
        skillRepository.save(new Skill(1L, "ES-Observability-Dev_3"));
        skillRepository.save(new Skill(2L, "ES-Performance-Dev_3"));
        skillRepository.save(new Skill(3L, "ES-Performance-Dev_4"));
        skillRepository.save(new Skill(4L, "ES-PlatformHealth-Dev_3"));
        skillRepository.save(new Skill(5L, "ES-PlatformHealth-Dev_4"));
        skillRepository.save(new Skill(6L, "ES-ProdTransitionEnablement-Dev_3"));
        skillRepository.save(new Skill(7L, "ES-ProdTransitionEnablement-QAFunc_3"));
        skillRepository.save(new Skill(8L, "ES-ProdTransitionEnablement-PM_3"));
    }
}
