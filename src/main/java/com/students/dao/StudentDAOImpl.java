package com.students.dao;


import com.students.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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

   @Override
    public Long countStudentsByCity(String city){
       Session session = sessionFactory.openSession();
       Criteria criteria = session.createCriteria(Student.class, "student")
               .createAlias("student.studentAddresses", "adresy", JoinType.LEFT_OUTER_JOIN);

       criteria.add( Restrictions.eq("adresy.city", city));
       criteria.setProjection(Projections.rowCount());

       Long count = (Long) criteria.uniqueResult();

       return count;

    }


}