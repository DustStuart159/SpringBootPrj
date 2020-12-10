/*
package com.dust.myhibernate.dao;

import com.dust.myhibernate.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MyHibernateDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Person> listAllRecords(){
        String hql = "FROM my_hibernate";
        Session session = this.sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery(hql, Person.class);
        return query.getResultList();
    }
}
*/
