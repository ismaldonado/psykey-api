package com.psykey.psykeyapirest.repository.model.access;

import com.psykey.psykeyapirest.repository.model.security.Rol;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "access")
public class Access {
    @Id
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname")
    private String fulName;

    @OneToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id", nullable = false)
    private Rol rol;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getFulName() {
        return this.fulName;
    }

    public void setFulName(final String fulName) {
        this.fulName = fulName;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(final Rol rol) {
        this.rol = rol;
    }
}
