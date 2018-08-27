package com.yarikwest.server.service;

import com.yarikwest.server.model.Father;
import com.yarikwest.server.repository.FatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FatherServiceImpl implements FatherService{

    @Autowired
    FatherRepository fatherRepository;

    @Override
    public void save(Father father) {
        fatherRepository.save(father);
    }

    @Override
    public Father getByFamilyId(Long familyId) {
        return fatherRepository.findByFamilyId(familyId);
    }

    @Override
    public List<Father> getAll() {
        return fatherRepository.findAll();
    }
}
