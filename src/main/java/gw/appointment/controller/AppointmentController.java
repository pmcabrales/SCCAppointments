package gw.appointment.controller;

import gw.appointment.entity.Appointment;
import gw.appointment.repository.AppointmentRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/appointments")
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
}
