package com.yarikwest.server.service;

import com.yarikwest.server.model.Child;
import com.yarikwest.server.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ChildServiceImpl implements ChildService{

    @Autowired
    ChildRepository childRepository;


    @Override
    public void save(Child child) {
        childRepository.save(child);
    }

    @Override
    public Child getById(Long id) {
        return childRepository.findById(id).orElse(null);
    }

    @Override
    public List<Child> getAll() {
        return childRepository.findAll();
    }

    @Override
    public List<Child> getBySearch(String firstName, String lastName, String pesel, Date birthDate, String sex) {
        return childRepository.findByFirstNameOrLastNameOrPeselOrBirthDateOrSex(firstName, lastName, pesel, birthDate, sex);
    }

    @Override
    public List<Child> getByFamilyId(Long id) {
        return childRepository.findByFamilyId(id);
    }


}
