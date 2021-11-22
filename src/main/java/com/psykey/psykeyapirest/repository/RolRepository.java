package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.security.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
