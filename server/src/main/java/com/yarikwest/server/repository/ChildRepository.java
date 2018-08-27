package com.yarikwest.server.repository;

import com.yarikwest.server.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child> findByFirstNameOrLastNameOrPeselOrBirthDateOrSex(String firstName, String lastName, String pesel, Date birthDate, String sex);

    List<Child> findByFamilyId(Long id);

}
