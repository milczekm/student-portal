package com.students.dao;


import com.students.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAllStudents() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        criteria.from(Student.class);
        List<Student> students = session.createQuery(criteria).getResultList();
        session.close();

        return students;
    }

    @Override
    public Student findStudentById(Long id) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class,id);
        session.close();
        return student;
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

  /*  @Override
    public Long countStudentsByCity(String city){
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add( Restrictions.eq("city", city));
        crit.setProjection(Projections.rowCount());

        Long count = crit.uniqueResult();

        return count;
    } */


}