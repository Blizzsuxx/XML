package com.clerk.clerkb.controller;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.izvestajOImunizaciji.IzvestajOImunizaciji;
import com.clerk.clerkb.model.vakcina.Vaccine;
import com.clerk.clerkb.model.vakcina.Vaccines;
import com.clerk.clerkb.service.IImmunizationService;
import com.clerk.clerkb.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "immunization", produces = MediaType.APPLICATION_XML_VALUE)
public class ImmunizationController {

    @Autowired
    private IImmunizationService service;

    @Autowired
    private IVaccineService vaccineService;

    @GetMapping("/report/{from}/{until}")
    public ResponseEntity<IzvestajOImunizaciji> getImmunizationReport(@PathVariable String from, @PathVariable String until){
        return new ResponseEntity<>(service.createImmunizationReport(from, until), HttpStatus.OK);
    }

    @GetMapping("/update-quantity/{vaccineId}/{newQuantity}")
    public ResponseEntity<?> setNewQuantity(@PathVariable long vaccineId, @PathVariable int newQuantity){
        vaccineService.updateQuantity(vaccineId, newQuantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/get-quantity/{vaccineId}", produces = "application/json")
    public ResponseEntity<Integer> getQuantity(@PathVariable long vaccineId){

        return new ResponseEntity<>(vaccineService.getQuantity(vaccineId), HttpStatus.OK);
    }

    @PostMapping("/save-vaccine")
    public ResponseEntity<Vaccine> saveVaccine(@RequestBody Vaccine vaccine){

        return new ResponseEntity<>(vaccineService.save(vaccine), HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-vaccines")
    public ResponseEntity<Vaccines> findAll(){

        return new ResponseEntity<>(vaccineService.findAll(), HttpStatus.OK);
    }

}
