package gw.appointment.controller;

import gw.appointment.entity.*;
import gw.appointment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.DateUtils;

@Controller
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    public AppointmentController(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/requestAppointment")
    public String showForm(Model model) {
        List<Service> services = serviceRepository.findAll();
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("servicesList", services); // Pass services from DB to the view

        model.addAttribute("contentFragment", "appointments/appointment_request");
        return "layout";
    }

    @PostMapping("/requestAppointment")
    public String submitForm(Appointment appointment, Model model) {
        appointmentRepository.save(appointment);
        //model.addAttribute("message", "Appointment registered successfully!");
        model.addAttribute("contentFragment", "appointments/appointment_confirmation");
        //model.addAttribute("resources", resourceRepository.findAll());
        //TODO devolve opciones con fechas

/*        List<Resource> resourceList = resourceRepository.findAll();
        resourceList.stream().map(r -> {

        });*/

        List<DateRange> optionsList = new ArrayList<>();
        optionsList.add(new DateRange(LocalDate.of(2025, 2, 1),LocalDate.of(2025, 2, 7)));
        optionsList.add(new DateRange(LocalDate.of(2025, 2, 14),LocalDate.of(2025, 2, 21)));
        optionsList.add(new DateRange(LocalDate.of(2025, 3, 2),LocalDate.of(2025, 3, 15)));
        model.addAttribute("optionsList", optionsList);

        return "layout";
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

/*    @PostMapping("/registerAppointment")
    public ResponseEntity<Appointment> registerAppointment(@RequestParam Integer id,
                                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
                                                           @RequestParam String description) {


        Appointment registerAppointment = new Appointment(id, dateTime, description);
        appointmentRepository.save(registerAppointment);

        return new ResponseEntity<Appointment>(registerAppointment,HttpStatus.CREATED);
    }*/

    @GetMapping("/appointment")
    public String showHome(Model model) {
        model.addAttribute("contentFragment", "appointments/appointment");
        return "layout";
    }
}
