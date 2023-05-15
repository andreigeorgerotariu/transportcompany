package com.transportcompany.transportcompany.models.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "driver_licence_category")
    private String driverLicenceCategory;
}