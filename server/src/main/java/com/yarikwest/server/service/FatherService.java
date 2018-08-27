package com.yarikwest.server.service;

import com.yarikwest.server.model.Father;

import java.util.List;

public interface FatherService {

    void save(Father father);

    Father getByFamilyId(Long familyId);

    List<Father> getAll();
}
