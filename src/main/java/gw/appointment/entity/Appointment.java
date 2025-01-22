package gw.appointment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Service> services = new HashSet<>();

}
