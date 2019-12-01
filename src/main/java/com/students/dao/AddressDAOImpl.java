package com.students.dao;

import com.students.model.Student;
import com.students.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Address> findAllAddresses() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> criteria = builder.createQuery(Address.class);
        criteria.from(Address.class);
        List<Address> studentAddresses = session.createQuery(criteria).getResultList();
        session.close();

        return studentAddresses;
    }

}
