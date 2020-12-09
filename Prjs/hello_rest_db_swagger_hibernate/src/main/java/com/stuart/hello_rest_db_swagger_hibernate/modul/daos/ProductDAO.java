package com.stuart.hello_rest_db_swagger_hibernate.modul.daos;

import com.stuart.hello_rest_db_swagger_hibernate.modul.entities.ProductEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductDAO implements CrudRepository<ProductEntity, Long> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <S extends ProductEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends ProductEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ProductEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    /**
     * @return trả về tất cả record có trong table `product`
     */
    @Override
    public Iterable<ProductEntity> findAll() {
        String hql = "FROM product";
        Session session = this.sessionFactory.getCurrentSession();
        Query<ProductEntity> query = session.createQuery(hql, ProductEntity.class);
        return query.getResultList();
    }

    /**
     * tìm tất cả record theo tiêu chí id cụ thể
     * @param ids
     * @return tất cả record có id cần tìm
     */
    @Override
    public Iterable<ProductEntity> findAllById(Iterable<Long> ids) {

        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ProductEntity productEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProductEntity> iterable) {

    }

    @Override
    public void deleteAll() {
    }
}
