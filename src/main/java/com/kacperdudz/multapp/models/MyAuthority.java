package com.kacperdudz.multapp.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "myauthority")
public class MyAuthority implements GrantedAuthority {

    @Id
    @Column(name="auth_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="authority")
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
