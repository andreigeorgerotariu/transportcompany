package com.transportcompany.transportcompany.models.entities;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "drivers_licence_category")
    private String driversLicenceCategory;

    public Drivers() {
    }

    public Drivers(String name, String driversLicenceCategory) {
        this.name = name;
        this.driversLicenceCategory = driversLicenceCategory;
    }

    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        this.Id = id;
    }
}


