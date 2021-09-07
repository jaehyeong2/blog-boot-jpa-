package com.jaeh.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 30)
    private String username;

    @Column(nullable = false,length = 100)
    private String password;


    @Column(nullable = false,length = 50)
    private String email;

    @CreationTimestamp
    private Timestamp timestamp;

}
