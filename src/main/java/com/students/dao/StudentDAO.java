package com.students.dao;

import java.util.List;
import com.students.model.Student;


public interface StudentDAO {

    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void delete(Student student);


}
