package com.kacperdudz.multapp.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="users")
public class ApplicationUser implements UserDetails {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="username")
    private final String username;

    @Column(name="password")
    private final String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "auth_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id", columnDefinition = "INT"),
            inverseJoinColumns = @JoinColumn(name = "auth_id",referencedColumnName = "auth_id", columnDefinition = "INT"))
    private final Set<MyAuthority> grantedAuthorities;

    @Column(name = "isaccountnonexpired")
    private final boolean isAccountNonExpired;

    @Column(name = "isaccountnonlocked")
    private final boolean isAccountNonLocked;

    @Column(name = "iscredentialsnonexpired")
    private final boolean isCredentialsNonExpired;

    @Column(name = "isenabled")
    private final boolean isEnabled;

    public ApplicationUser() {
        username = "";
        password = "";
        grantedAuthorities = null;
        isAccountNonExpired = true;
        isAccountNonLocked = true;
        isCredentialsNonExpired = true;
        isEnabled = true;
    }

    public ApplicationUser(String username, String password, Set<MyAuthority> grantedAuthorities, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
        System.out.println("in constructor");
        this.username = username;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

}
