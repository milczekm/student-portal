package com.students.service;

import com.students.dao.StudentDAO;
import com.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDao;

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }

    @Override
    public Student findStudentById(Long id) {
        return studentDao.findStudentById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student);
    }
}