package com.yarikwest.server.service;

import com.yarikwest.server.model.Family;

import java.util.List;

public interface FamilyService {

    void save(Family family);

    Family getById(Long id);

    List<Family> getAll();
}
