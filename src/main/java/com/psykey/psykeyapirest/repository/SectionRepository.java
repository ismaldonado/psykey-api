package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.security.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
}
