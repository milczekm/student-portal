package com.students.model;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code", length = 6)
    private String zipCode;
}
