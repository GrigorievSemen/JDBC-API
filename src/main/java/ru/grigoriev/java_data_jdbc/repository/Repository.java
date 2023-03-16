package ru.grigoriev.java_data_jdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
;

@org.springframework.stereotype.Repository
public class Repository {
    private final String GET_PRODUCT_NAME = "SELECT ord.product_name FROM test.ORDERS ord\n" +
            "    JOIN test.CUSTOMERS cus on ord.customer_id = cus.id\n" +
            "    WHERE LOWER(cus.name) = LOWER (:name);";

    @PersistenceContext
    EntityManager entityManager;

    public List<String> getProductName(String name) {
        return entityManager.createQuery(GET_PRODUCT_NAME, String.class).setParameter("name",name).getResultList();
    }
}