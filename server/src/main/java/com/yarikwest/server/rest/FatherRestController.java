package com.yarikwest.server.rest;

import com.yarikwest.server.model.Family;
import com.yarikwest.server.model.Father;
import com.yarikwest.server.service.FamilyService;
import com.yarikwest.server.service.FatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/family")
@CrossOrigin(origins = "http://localhost:4200")
public class FatherRestController {

    @Autowired
    FatherService fatherService;

    @Autowired
    FamilyService familyService;

    @RequestMapping(value = "/{id}/father", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Father> readFather(@PathVariable("id") Long familyId){

        if (familyId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Father father = this.fatherService.getByFamilyId(familyId);

        if (father == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(father, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/father", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Father> addFatherToFamily(@PathVariable("id") Long familyId, @RequestBody @Valid Father father){

        Family family = familyService.getById(familyId);

        if (father == null || family == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        father.setFamily(family);
        family.setFather(father);

        this.fatherService.save(father);

        return new ResponseEntity<>(father, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/father", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Father>> readAllFather(){
        List<Father> fathers = this.fatherService.getAll();

        if (fathers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(fathers, HttpStatus.OK);
    }
}
