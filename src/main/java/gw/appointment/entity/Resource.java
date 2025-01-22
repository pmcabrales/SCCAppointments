package gw.appointment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String fullName;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Availability> availabilities = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(name = "resource_id"))
    private Set<Skill> skills = new HashSet<>();

    // Custom method to add availability
    public void addAvailability(LocalDate date, Integer hours) {
        Availability availability = new Availability();
        availability.setDate(date);
        availability.setHours(hours);
        //availability.setResource(this);
        availabilities.add(availability);
    }
}
