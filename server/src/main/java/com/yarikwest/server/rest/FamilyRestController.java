package com.yarikwest.server.rest;

import com.yarikwest.server.model.Child;
import com.yarikwest.server.model.Family;
import com.yarikwest.server.model.Father;
import com.yarikwest.server.service.ChildService;
import com.yarikwest.server.service.FamilyService;
import com.yarikwest.server.service.FatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/family")
@CrossOrigin(origins = "http://localhost:4200")
public class FamilyRestController {

    @Autowired
    FamilyService familyService;

    @Autowired
    FatherService fatherService;

    @Autowired
    ChildService childService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Family> createFamily() {
        Family family = new Family();

        this.familyService.save(family);
        return new ResponseEntity<>(family, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Object>> readFamily(@PathVariable("id") Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Object> family = new ArrayList<>();
        Father father = fatherService.getByFamilyId(id);
        List<Child> children = childService.getByFamilyId(id);

        if (father != null) {
            family.add(father);
            if (!children.isEmpty())
                family.add(children);
        }

        if (family.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(family, HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Set<Father>> searchChild(@RequestBody Child child) {

        if (child == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Set<Father> fatherHashSet = new HashSet<>();
        List<Child> children = this.childService.getBySearch(
                child.getFirstName(),
                child.getLastName(),
                child.getPesel(),
                child.getBirthDate(),
                child.getSex());

        if (children.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (Child foo : children) {
            fatherHashSet.add(fatherService.getByFamilyId(foo.getFamily().getId()));
        }

        return new ResponseEntity<>(fatherHashSet, HttpStatus.OK);
    }

}
