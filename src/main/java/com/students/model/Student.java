package com.students.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    Date birthDate;

    @Column(name = "pesel")
    private byte PESEL[] = new byte[11];


}
