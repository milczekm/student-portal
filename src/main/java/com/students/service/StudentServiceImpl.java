package com.students.service;

import com.students.dao.StudentDAO;
import com.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
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
    

    @Override
    public Long countStudentsByCity(String city) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("Incorrect parameter city!");
        }
        return studentDao.countStudentsByCity(city);
    }

    @Override
    public Integer countStudentsByAge(Integer age) {
        Integer count = 0;
        List<Student> students = findAllStudents();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Integer currentYear = calendar.get(Calendar.YEAR);
        for (Student s : students) {
            Integer yearOfBirth = s.getBirthDate().get(Calendar.YEAR);
            if (currentYear - yearOfBirth == age) {
                count++;
            }
        }

        return count;
    }
}
