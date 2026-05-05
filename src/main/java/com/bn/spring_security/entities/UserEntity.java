package com.bn.spring_security.entities;

import com.bn.spring_security.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table (name = "UsuarioProduto")
public class UserEntity implements UserDetails{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String login;
    private String password;
    private UserRole role;

    public UserEntity(){

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
        new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return login;
    }

}
