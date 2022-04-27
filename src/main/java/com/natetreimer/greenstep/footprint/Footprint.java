package com.natetreimer.greenstep.footprint;

import com.natetreimer.greenstep.security.User;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "footprint")
public class Footprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "footprint_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false)
    private Long year;

    @Column(nullable = false)
    private Double weight;

    public Footprint() {
    }

    public Footprint(Long id, User user, Long year, Double weight) {
        this.id = id;
        this.user = user;
        this.year = year;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footprint footprint = (Footprint) o;
        return Objects.equals(id, footprint.id) && Objects.equals(year, footprint.year) && Objects.equals(weight, footprint.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, weight);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
