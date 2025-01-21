package gw.appointment.config;

import gw.appointment.entity.Appointment;
import gw.appointment.entity.Service;
import gw.appointment.entity.ServiceSkill;
import gw.appointment.entity.Skill;
import gw.appointment.repository.AppointmentRepository;
import gw.appointment.repository.ServiceRepository;
import gw.appointment.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private SkillRepository skillRepository;


    public DataLoader(AppointmentRepository appointmentRepository, ServiceRepository serviceRepository, SkillRepository skillRepository){
        this.appointmentRepository = appointmentRepository;
        this.serviceRepository = serviceRepository;
        this.skillRepository = skillRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        loadAppointments();
        loadSkills();
        loadServices();
    }

    private void loadAppointments() {
        //appointmentRepository.save(new Appointment(1,LocalDateTime.of(LocalDate.of(2025,1,16), LocalTime.of(12,30)),"Test Appointment"));
    }

    private void loadServices(){
        Service service = serviceRepository.save(new Service(1L, "GWCP Observability", new HashSet<>()));
        service.getSkills().add(new ServiceSkill(1L,service, skillRepository.getReferenceById(1L), 40));
        serviceRepository.save(service);

        service = serviceRepository.save(new Service(2L, "Performance Diagnostics", new HashSet<>()));
        service.getSkills().add(new ServiceSkill(2L,service, skillRepository.getReferenceById(1L), 16));
        serviceRepository.save(service);
        service.getSkills().add(new ServiceSkill(3L,service, skillRepository.getReferenceById(2L), 80));
        serviceRepository.save(service);
        service.getSkills().add(new ServiceSkill(4L,service, skillRepository.getReferenceById(3L), 20));
        serviceRepository.save(service);

        service = serviceRepository.save(new Service(3L, "Platform Health Review", new HashSet<>()));
        service.getSkills().add(new ServiceSkill(5L,service, skillRepository.getReferenceById(4L), 100));
        serviceRepository.save(service);
        service.getSkills().add(new ServiceSkill(6L,service, skillRepository.getReferenceById(5L), 20));
        serviceRepository.save(service);

        service = serviceRepository.save(new Service(4L, "Production Transition Enablement", new HashSet<>()));
        service.getSkills().add(new ServiceSkill(7L,service, skillRepository.getReferenceById(6L), 40));
        serviceRepository.save(service);
        service.getSkills().add(new ServiceSkill(8L,service, skillRepository.getReferenceById(7L), 8));
        serviceRepository.save(service);
        service.getSkills().add(new ServiceSkill(9L,service, skillRepository.getReferenceById(8L), 8));
        serviceRepository.save(service);
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
