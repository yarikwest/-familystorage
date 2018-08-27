package com.yarikwest.server.service;

import com.yarikwest.server.model.Family;
import com.yarikwest.server.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    FamilyRepository familyRepository;

    @Override
    public void save(Family family) {
        familyRepository.save(family);
    }

    @Override
    public Family getById(Long id) {
        return familyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Family> getAll() {
        return familyRepository.findAll();
    }
}
