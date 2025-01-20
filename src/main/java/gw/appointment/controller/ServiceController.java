package gw.appointment.controller;

import gw.appointment.entity.Service;
import gw.appointment.entity.ServiceSkill;
import gw.appointment.entity.Skill;
import gw.appointment.repository.ServiceRepository;
import gw.appointment.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public String listServices(Model model) {
        model.addAttribute("services", serviceRepository.findAll());

        model.addAttribute("contentFragment", "services/services");
        return "layout";
    }

    @GetMapping("/new")
    public String showServiceForm(Model model) {
        model.addAttribute("service", new Service());
        model.addAttribute("allSkills", skillRepository.findAll());

        model.addAttribute("contentFragment", "services/service-form");
        return "layout";
    }

    @PostMapping
    public String saveService(Service service, @RequestParam Map<Long, Integer> skillHours, Model model) {
        for (Map.Entry<Long, Integer> entry : skillHours.entrySet()) {
            Skill skill = skillRepository.findById(entry.getKey()).orElseThrow();
            ServiceSkill serviceSkill = new ServiceSkill();
            serviceSkill.setService(service);
            serviceSkill.setSkill(skill);
            serviceSkill.setHours(entry.getValue());
            service.getSkills().add(serviceSkill);
        }
        serviceRepository.save(service);

        model.addAttribute("contentFragment", "services/services");
        return "layout";
    }

}
