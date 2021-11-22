package com.psykey.psykeyapirest.repository.model.security;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RolPermissionPK implements Serializable {

    private static final long serialVersionUID = -5580362675901168754L;

    @Id
    @Column(name = "rol_id")
    private Long rolId;

    @Id
    @Column(name = "permission_id")
    private Long permissionId;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final RolPermissionPK that = (RolPermissionPK) o;
        return Objects.equals(this.rolId, that.rolId) && Objects.equals(this.permissionId, that.permissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rolId, this.permissionId);
    }
}
