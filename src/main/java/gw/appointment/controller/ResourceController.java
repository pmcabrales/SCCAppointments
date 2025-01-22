package gw.appointment.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import gw.appointment.entity.Skill;
import gw.appointment.repository.ResourceRepository;
import gw.appointment.entity.Resource;
import gw.appointment.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private SkillRepository skillRepository;
    private final ResourceRepository resourceRepository;

    public ResourceController(ResourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }

    @GetMapping()
    public String showResourceList(Model model) {
        List<Resource> resources = resourceRepository.findAll();
        model.addAttribute("resources", resources);
        model.addAttribute("contentFragment", "resources/resources");
        return "layout";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        List<Skill> skills = skillRepository.findAll();
        model.addAttribute("resource", new Resource());
        model.addAttribute("skillsList", skills); // Pass skills from DB to the view

        model.addAttribute("contentFragment", "resources/resource-form");
        return "layout";
    }

    @PostMapping("/new")
    public String submitForm(@RequestParam String fullName,
                             @RequestParam String email,
                             @RequestParam String availabilities,
                             @RequestParam Set<String> skills,  Model model) throws Exception {

        Resource resource = new Resource();
        resource.setFullName(fullName);
        resource.setEmail(email);

        ObjectMapper objectMapper = new ObjectMapper();
        // Convert JSON string to Map<LocalDate, Integer>
        Map<String, Integer> availabilityMap = objectMapper.readValue(
                availabilities, new TypeReference<Map<String, Integer>>() {});
        availabilityMap.forEach((date, hours) ->  resource.addAvailability(LocalDate.parse(date), hours));

        // Process skills
        Set<Skill> resourceSkills = new HashSet<>();
        for (String skillName : skills) {
            Skill skill = skillRepository.findById(Long.parseLong(skillName)).orElseThrow(Exception::new);
            resourceSkills.add(skill);
        }
        resource.setSkills(resourceSkills);

        // Save resource
        resourceRepository.save(resource);

        List<Resource> resources = resourceRepository.findAll();
        model.addAttribute("resources", resources);
        model.addAttribute("contentFragment", "resources/resources");
        return "layout";
    }
}
