package com.yarikwest.server.repository;

import com.yarikwest.server.model.Father;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatherRepository extends JpaRepository<Father, Long> {

    Father findByFamilyId(Long familyId);
}
