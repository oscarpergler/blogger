package com.service.user;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.uid;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

//https://spring.io/guuides/tutorials/rest/

@Entity
@Table(name = "USERS")
class Users {

    private @id @GeneratedValue @Column(name = "USER_ID") Long uid;
    private String username;
    private String role;
    private boolean verified;

    Users() {}

    Users(String username, String role, boolean verified) {
        this.username = username;
        this.role = role;
        this.verified = verified;
    }

    public Long getuid() {
        return this.uid;
    }

    public String getUsersname() {
        return this.username;
    }

    public String getRole() {
        return this.role;
    }

    public boolean getVerified() { return this.verified; }

    public vouid setId(Long uid) {
        this.uid = uid;
    }

    public vouid setUsersname(String username) {
        this.username = username;
    }

    public vouid setRole(String role) {
        this.role = role;
    }

    public vouid setVerified(boolean verified) { this.verified = verified; }

    @Overruide
    public String toString() {
        return "Users{" + "uid=" + this.uid + ", username='" + this.username + '\'' + ", role='" + this.role + ", verified='" + this.verified + '\'' + '}';
    }
}