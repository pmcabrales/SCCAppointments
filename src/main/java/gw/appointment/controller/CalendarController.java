package gw.appointment.controller;

import gw.appointment.entity.Resource;
import gw.appointment.entity.Skill;
import gw.appointment.repository.ResourceRepository;
import gw.appointment.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CalendarController {

    public CalendarController(){
    }

    @GetMapping("/calendar")
    public String showCalendar(Model model) {
        model.addAttribute("contentFragment", "appointments/calendar");
        return "layout";
    }

}
