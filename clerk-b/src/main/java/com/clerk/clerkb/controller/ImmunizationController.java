package com.clerk.clerkb.controller;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.service.IImmunizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.base.ResourceSet;

import java.util.Date;

@RestController
@RequestMapping(value = "immunization", produces = MediaType.APPLICATION_XML_VALUE)
public class ImmunizationController {

    @Autowired
    private IImmunizationService service;

    @GetMapping("/report/{from}/{until}")
    public ResponseEntity<String> getImmunizationReport(@PathVariable String from, @PathVariable String until){
        service.createImmunizationReport(from, until);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/update-quantity/{newQuantity}")
    public ResponseEntity<String> setNewQuantity(@PathVariable int newQuantity){

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
