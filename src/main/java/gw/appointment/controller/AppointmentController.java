package gw.appointment.controller;

import gw.appointment.entity.Appointment;
import gw.appointment.repository.AppointmentRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping()
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    @PostMapping("/registerAppointment")
    public ResponseEntity<Appointment> registerAppointment(@RequestParam Integer id,
                                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
                                                           @RequestParam String description) {


        Appointment registerAppointment = new Appointment(id, dateTime, description);
        appointmentRepository.save(registerAppointment);

        return new ResponseEntity<Appointment>(registerAppointment,HttpStatus.CREATED);
    }

    @GetMapping("/appointment")
    public String showHome(Model model) {
        model.addAttribute("contentFragment", "appointments/appointment");
        return "layout";
    }
}
