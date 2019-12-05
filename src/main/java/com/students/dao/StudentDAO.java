package com.students.dao;

import java.util.List;
import com.students.model.Student;


public interface StudentDAO {

    List<Student> findAllStudents();
    Student findStudentById(Long id);
    void saveStudent(Student student);
    void deleteStudent(Student student);
    Long countStudentsByCity(String city);
    Integer countStudentsByAge(Integer age);


}
