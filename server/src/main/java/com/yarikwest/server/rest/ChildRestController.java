package com.yarikwest.server.rest;

import com.yarikwest.server.model.Child;
import com.yarikwest.server.model.Family;
import com.yarikwest.server.service.ChildService;
import com.yarikwest.server.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/family")
@CrossOrigin(origins = "http://localhost:4200")
public class ChildRestController {

    @Autowired
    ChildService childService;

    @Autowired
    FamilyService familyService;

    @RequestMapping(value = "/{id}/child", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Child> readChild(@PathVariable("id") Long childId) {

        if (childId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Child child = this.childService.getById(childId);

        if (child == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(child, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/child", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Child> addChildToFamily(@PathVariable("id") Long familyId, @RequestBody Child child) {

        Family family = this.familyService.getById(familyId);

        if (child == null || family == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        child.setFamily(family);
        family.getChildren().add(child);

        this.childService.save(child);

        return new ResponseEntity<>(child, HttpStatus.CREATED);
    }

}

