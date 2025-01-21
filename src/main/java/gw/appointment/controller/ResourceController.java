package gw.appointment.controller;

import gw.appointment.entity.Skill;
import gw.appointment.repository.ResourceRepository;
import gw.appointment.entity.Resource;
import gw.appointment.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String submitForm(Resource resource, Model model) {
        resourceRepository.save(resource);
        model.addAttribute("message", "Resource registered successfully!");
        List<Resource> resources = resourceRepository.findAll();
        model.addAttribute("resources", resources);
        model.addAttribute("contentFragment", "resources/resources");
        return "layout";
    }
}
