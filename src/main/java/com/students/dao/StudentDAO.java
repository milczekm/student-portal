package com.students.dao;

import java.util.List;
import com.students.model.Student;

public interface StudentDAO {

    public void addStudent(Student s);
    public void updateStudent(Student s);
    public List<Student> listStudents();
    public Student getstudentById(int id);
    public void removeStudent(int id);
}