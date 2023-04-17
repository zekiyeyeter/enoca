package com.example.enoca.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Orders> orders;

}
