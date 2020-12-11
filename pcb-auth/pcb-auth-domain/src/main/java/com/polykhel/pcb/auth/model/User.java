package com.polykhel.pcb.auth.model;

import com.polykhel.pcb.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled", nullable = false)
    @Type(type = "yes_no")
    @ColumnDefault("'N'")
    private boolean enabled;

    @Column(name = "account_non_expired", nullable = false)
    @Type(type = "yes_no")
    @ColumnDefault("'N'")
    private boolean accountNonExpired;

    @Column(name = "credentials_non_expired", nullable = false)
    @Type(type = "yes_no")
    @ColumnDefault("'N'")
    private boolean credentialsNonExpired;

    @Column(name = "account_non_locked", nullable = false)
    @Type(type = "yes_no")
    @ColumnDefault("'N'")
    private boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}

