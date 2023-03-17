package ru.grigoriev.java_data_jdbc.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String phone_number;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private List<Order> orderList;
}
