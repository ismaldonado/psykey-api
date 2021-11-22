package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.security.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
