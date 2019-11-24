package com.students.service;

import com.students.dao.StudentDAO;
import com.students.model.Student;

public class StudentService {


        private static StudentDao studentDao;

        public StudentService() {
            studentDao = new StudentDao();
        }

        public void persist(Student entity) {
            studentDao.openCurrentSessionwithTransaction();
            studentDao.persist(entity);
            studentDao.closeCurrentSessionwithTransaction();
        }

        public void update(Student entity) {
            studentDao.openCurrentSessionwithTransaction();
            studentDao.update(entity);
            studentDao.closeCurrentSessionwithTransaction();
        }

        public Student findById(String id) {
            studentDao.openCurrentSession();
            Student student = studentDao.findById(id);
            studentDao.closeCurrentSession();
            return student;
        }

        public void delete(String id) {
            studentDao.openCurrentSessionwithTransaction();
            Student student = studentDao.findById(id);
            studentDao.delete(student);
            studentDao.closeCurrentSessionwithTransaction();
        }

        public List<Student> findAll() {
            studentDao.openCurrentSession();
            List<Student> students = studentDao.findAll();
            studentDao.closeCurrentSession();
            return students;
        }

        public void deleteAll() {
            studentDao.openCurrentSessionwithTransaction();
            studentDao.deleteAll();
            studentDao.closeCurrentSessionwithTransaction();
        }

        public StudentDao studentDao() {
            return studentDao;
        }

}
