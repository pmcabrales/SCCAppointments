package gw.appointment.controller;

import gw.appointment.repository.ResourceRepository;
import gw.appointment.entity.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResourceController {
    private final ResourceRepository resourceRepository;

    public ResourceController(ResourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }

    @GetMapping("/registerResource")
    public String showForm(Model model) {
        model.addAttribute("resource", new Resource());
        return "resources/resource_register";
    }

    @PostMapping("/registerResource")
    public String submitForm(Resource resource, Model model) {
        resourceRepository.save(resource);
        model.addAttribute("message", "Resource registered successfully!");
        return "resources/resource_register";
    }
}
