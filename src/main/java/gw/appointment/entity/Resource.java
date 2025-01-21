package gw.appointment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@AllArgsConstructor
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String fullName;

    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(name = "resource_id"))
    private Set<Skill> skills = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "availability", joinColumns = @JoinColumn(name = "resource_id"))
    @MapKeyColumn(name = "date")
    @Column(name = "availability_hours")
    private Map<Date, Integer> availability = new HashMap<>();

    public Resource() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Map<Date, Integer> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<Date, Integer> availability) {
        this.availability = availability;
    }
}
