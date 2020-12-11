package com.polykhel.pcb.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO implements UserDetails {

    /**
     * Username of the user.
     */
    private String username;

    /**
     * Password of the user.
     */
    private String password;

    /**
     * If user is enabled.
     */
    private boolean enabled;

    /**
     * Email address associated to the user.
     */
    private String email;

    /**
     * If account is not yet expired.
     */
    private boolean accountNonExpired;

    /**
     * If account is not locked.
     */
    private boolean accountNonLocked;

    /**
     * If account credentials are not yet expired.
     */
    private boolean credentialsNonExpired;

    private List<RoleDTO> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        /*roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            role.getPermissions().forEach(permission -> new SimpleGrantedAuthority(permission.getName()));
        });*/

        return authorities;
    }

}
