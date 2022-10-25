package com.example.vulcanizare.domain.security;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;

    //@Singular
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities;


    //@Builder.Default
    private Boolean enabled = true;

    //@Builder.Default
    private Boolean accountNotExpired = true;

    //@Builder.Default
    private Boolean accountNotLocked = true;

   // @Builder.Default
    private Boolean credentialsNotExpired = true;

    public User() {
    }

    public User(String username, String password, Authority authority) {
        this.username = username;
        this.password = password;
        this.authorities = new HashSet<>();
        this.authorities.add(authority);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAccountNotExpired() {
        return accountNotExpired;
    }

    public void setAccountNotExpired(Boolean accountNotExpired) {
        this.accountNotExpired = accountNotExpired;
    }

    public Boolean getAccountNotLocked() {
        return accountNotLocked;
    }

    public void setAccountNotLocked(Boolean accountNotLocked) {
        this.accountNotLocked = accountNotLocked;
    }

    public Boolean getCredentialsNotExpired() {
        return credentialsNotExpired;
    }

    public void setCredentialsNotExpired(Boolean credentialsNotExpired) {
        this.credentialsNotExpired = credentialsNotExpired;
    }
}
