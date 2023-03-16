package ru.grigoriev.java_data_jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@org.springframework.data.relational.core.mapping.Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "timestamp default now()", nullable = false)
    @CreatedDate
    private LocalDate date;
    @Column(name = "customer_id",nullable = false)
    @ManyToOne
    Customer customer;
    @Column(nullable = false)
    private String product_name;
    @Column(nullable = false)
    private double amount;
}
