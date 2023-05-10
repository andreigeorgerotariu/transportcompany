package com.transportcompany.transportcompany.models.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "drivers_licence_category")
    private String driversLicenceCategory;
}

