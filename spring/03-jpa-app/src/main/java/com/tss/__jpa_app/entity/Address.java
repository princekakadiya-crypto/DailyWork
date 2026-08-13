package com.tss.__jpa_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Column(name = "address_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String pincode;
}
