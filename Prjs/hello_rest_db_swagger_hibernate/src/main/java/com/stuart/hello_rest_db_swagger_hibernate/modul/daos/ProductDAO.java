package com.stuart.hello_rest_db_swagger_hibernate.modul.daos;

import com.stuart.hello_rest_db_swagger_hibernate.modul.entities.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<ProductEntity> listAllRecords(){
        String hql = "FROM product";
        Session session = this.sessionFactory.getCurrentSession();
        Query<ProductEntity> query = session.createQuery(hql, ProductEntity.class);
        return query.getResultList();
    }
}
