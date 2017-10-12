package com.neiron.neiron.entities;



import javax.persistence.*;

@Entity
public class UserRoles {
    @Id
    @GeneratedValue
    Integer userRoleId;
    @ManyToOne
    @JoinColumn(name="username")
    Users username;
    String role;
} 