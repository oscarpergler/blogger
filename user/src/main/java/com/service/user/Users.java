package com.service.user;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
class Users {

    private @Id @GeneratedValue Long id;
    private String username;
    private String role;
    private boolean verified;

    Users() {}

    Users(String username, String role, boolean verified) {
        this.username = username;
        this.role = role;
        this.verified = verified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsersname() {
        return this.username;
    }

    public String getRole() {
        return this.role;
    }

    public boolean getVerified() { return this.verified; }

    public void setUsersname(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setVerified(boolean verified) { this.verified = verified; }

    @Override
    public String toString() {
        return "Users{" + "id=" + this.id + ", username='" + this.username + '\'' + ", role='" + this.role + ", verified='" + this.verified + '\'' + '}';
    }
}