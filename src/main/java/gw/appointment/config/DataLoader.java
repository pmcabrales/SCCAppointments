package gw.appointment.config;

import gw.appointment.entity.Appointment;
import gw.appointment.entity.EssentialService;
import gw.appointment.entity.Skill;
import gw.appointment.repository.AppointmentRepository;
import gw.appointment.repository.EssentialServiceRepository;
import gw.appointment.repository.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final AppointmentRepository appointmentRepository;
    private final EssentialServiceRepository essentialServiceRepository;
    private final SkillRepository skillRepository;

    public DataLoader(AppointmentRepository appointmentRepository, EssentialServiceRepository essentialServiceRepository, SkillRepository skillRepository){
        this.appointmentRepository = appointmentRepository;
        this.essentialServiceRepository = essentialServiceRepository;
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
        essentialServiceRepository.save(new EssentialService(1, "GWCP Observability"));
        essentialServiceRepository.save(new EssentialService(2, "Performance Diagnostics"));
        essentialServiceRepository.save(new EssentialService(3, "Platform Health Review"));
        essentialServiceRepository.save(new EssentialService(4, "Production Transition Enablement"));
    }

    private void loadSkills(){
        skillRepository.save(new Skill(1, "ES-Observability-Dev_3"));
        skillRepository.save(new Skill(2, "ES-Performance-Dev_3"));
        skillRepository.save(new Skill(3, "ES-Performance-Dev_4"));
        skillRepository.save(new Skill(4, "ES-PlatformHealth-Dev_3"));
        skillRepository.save(new Skill(5, "ES-PlatformHealth-Dev_4"));
        skillRepository.save(new Skill(6, "ES-ProdTransitionEnablement-Dev_3"));
        skillRepository.save(new Skill(7, "ES-ProdTransitionEnablement-QAFunc_3"));
        skillRepository.save(new Skill(8, "ES-ProdTransitionEnablement-PM_3"));
    }
}
