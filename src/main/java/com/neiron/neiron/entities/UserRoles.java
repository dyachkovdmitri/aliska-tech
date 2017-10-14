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

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}