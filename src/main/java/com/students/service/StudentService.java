package com.students.service;

import com.students.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(Long id);
    void saveStudent(Student student);
    void deleteStudent(Student student);
}
