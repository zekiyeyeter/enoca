package com.example.enoca.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private int age;

    @OneToMany(mappedBy="customer")
    @ToString.Exclude
    private transient Set<Orders> orders;

}
