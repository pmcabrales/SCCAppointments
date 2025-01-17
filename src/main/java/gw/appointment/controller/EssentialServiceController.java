package gw.appointment.controller;

import gw.appointment.entity.EssentialService;
import gw.appointment.repository.EssentialServiceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EssentialServiceController {

    private EssentialServiceRepository essentialServiceRepository;

    public EssentialServiceController (EssentialServiceRepository essentialServiceRepository) {
        this.essentialServiceRepository = essentialServiceRepository;
    }

    @GetMapping("/essentialServices")
    public List<EssentialService> findEssentialServices(){
        return essentialServiceRepository.findAll();
    }

}
