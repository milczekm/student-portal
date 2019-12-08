package com.students.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Calendar birthDate;

    @Column(name = "pesel", length = 11)
    String pesel;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Address> studentAddresses;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSecondName(){
        return secondName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Calendar getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate){
        this.birthDate = birthDate;
    }

    public String getPesel(){
        return pesel;
    }

    public void setPesel(String pesel){
        this.pesel = pesel;
    }

    public Set<Address> getStudentAddresses(){
        return studentAddresses;
    }

    public void setStudentAddresses(Set<Address> studentAddresses){
        this.studentAddresses = studentAddresses;
    }
}
