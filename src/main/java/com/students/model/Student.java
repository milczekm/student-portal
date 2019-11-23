package com.students.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="STUDENT")
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    private String secondName;

    private String lastName;

    Date birthDate;

    private byte PESEL[] = new byte[11];


}
