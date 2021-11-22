package com.psykey.psykeyapirest.repository.model.security;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rol_permission")
@IdClass(RolPermissionPK.class)
public class RolPermission {

    @Id
    @Column(name = "rol_id")
    private Long rolId;

    @Id
    @Column(name = "permission_id")
    private Long permissionId;

    @ManyToOne
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "rol_id", referencedColumnName = "id", insertable = false, updatable = false))
    })
    private Rol rol;

    @ManyToOne
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "permission_id", referencedColumnName = "id", insertable = false, updatable = false))
    })
    private Permission permission;

    public Long getRolId() {
        return this.rolId;
    }

    public void setRolId(final Long rolId) {
        this.rolId = rolId;
    }

    public Long getPermissionId() {
        return this.permissionId;
    }

    public void setPermissionId(final Long permissionId) {
        this.permissionId = permissionId;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(final Rol rol) {
        this.rol = rol;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public void setPermission(final Permission permission) {
        this.permission = permission;
    }
}
