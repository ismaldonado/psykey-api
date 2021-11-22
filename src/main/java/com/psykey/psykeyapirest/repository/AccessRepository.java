package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.access.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, String> {
    Access findAccessByUsername(final String username);
}
