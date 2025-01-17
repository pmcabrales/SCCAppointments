package gw.appointment.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(name = "resource_id"))
    private Set<String> skills = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "availability", joinColumns = @JoinColumn(name = "resource_id"))
    @MapKeyColumn(name = "date")
    @Column(name = "availability_hours")
    private Map<Date, Integer> availability = new HashMap<>();

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

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }


}
