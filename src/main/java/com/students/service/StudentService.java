package com.students.service;

import com.students.model.Student;

import java.util.List;

public interface StudentService {
    public void addStudent(Student s);
    public void updateStudent(Student s);
    public List<Student> listStudents();
    public Student getStudentById(int id);
    public void removeStudent(int id);
}
