package ru.grigoriev.java_data_jdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    private final NamedParameterJdbcTemplate template;
    String scriptFileName = read();

    public Repository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    private static String read() {
        try (InputStream is = new ClassPathResource("db/changelog/get_product_name.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        return template.queryForList(scriptFileName, Map.of("name", name), String.class);
    }
}