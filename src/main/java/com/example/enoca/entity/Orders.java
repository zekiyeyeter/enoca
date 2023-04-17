package com.example.enoca.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date createdAt;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName = "customerId", nullable=false)
    @JsonIgnore
    private Customer customer;

}
