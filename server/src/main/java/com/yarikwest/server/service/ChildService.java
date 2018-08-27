package com.yarikwest.server.service;

import com.yarikwest.server.model.Child;

import java.sql.Date;
import java.util.List;

public interface ChildService {

    void save(Child child);

    Child getById(Long id);

    List<Child> getAll();

    List<Child> getBySearch(String firstName, String lastName, String pesel, Date birthDate, String sex);

    List<Child> getByFamilyId(Long id);
}
