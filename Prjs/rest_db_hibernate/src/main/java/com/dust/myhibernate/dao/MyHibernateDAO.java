package com.dust.myhibernate.dao;

import com.dust.myhibernate.entities.MyHibernateEntity;
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

    public List<MyHibernateEntity> listAllRecords(){
        String hql = "FROM my_hibernate";
        Session session = this.sessionFactory.getCurrentSession();
        Query<MyHibernateEntity> query = session.createQuery(hql, MyHibernateEntity.class);
        return query.getResultList();
    }
}
