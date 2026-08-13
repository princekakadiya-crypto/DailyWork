package com.tss.spring_security.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long userId;

    @Column
    private String userName;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
