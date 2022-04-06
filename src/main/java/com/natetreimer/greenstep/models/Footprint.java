package com.natetreimer.greenstep.models;

import javax.persistence.*;


@Entity
@Table
public class Footprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long year;

    @Column
    private Double footprint;

    public Footprint() {
    }

    public Footprint(Long id, Long year, Double footprint) {
        this.id = id;
        this.year = year;
        this.footprint = footprint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Double getFootprint() {
        return footprint;
    }

    public void setFootprint(Double footprint) {
        this.footprint = footprint;
    }
}
