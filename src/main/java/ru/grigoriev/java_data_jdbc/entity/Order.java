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
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "timestamp default now()", nullable = false)
    @CreatedDate
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    @Column(nullable = false)
    private String product_name;
    @Column(nullable = false)
    private double amount;
}
