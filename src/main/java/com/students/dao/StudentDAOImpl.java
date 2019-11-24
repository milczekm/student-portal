package com.students.dao;


import com.students.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {

    private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory ss){
        this.sessionFactory = ss;
    }

    @Override
    public void addStudent(Student s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
        logger.info("Student saved successfully, Student Details="+s);
    }

    @Override
    public void updateStudent(Student s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
        logger.info("Student updated successfully, Student Details="+s);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> personsList = session.createQuery("from Student").list();
        for(Student s : listStudents()){
            logger.info("Student List::"+s);
        }
        return personsList;
    }

    @Override
    public Student getStudentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student s = (Student) session.load(Student.class, new Integer(id));
        logger.info("Student loaded successfully, Student details="+s);
        return s;
    }

    @Override
    public void removeStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student s = (Student) session.load(Student.class, new Integer(id));
        if(null != s){
            session.delete(s);
        }
        logger.info("Student deleted successfully, student details="+s);
    }

}
