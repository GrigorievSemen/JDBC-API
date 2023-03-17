package ru.grigoriev.java_data_jdbc.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    private final String GET_PRODUCT_NAME = "select o.product_name from Order o join o.customer c WHERE LOWER(c.name) = LOWER(:name)";

    @PersistenceContext
    EntityManager entityManager;

    public List<String> getProductName(String name) {
        return entityManager.createQuery(GET_PRODUCT_NAME, String.class).setParameter("name", name).getResultList();
    }
}