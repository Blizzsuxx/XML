package com.example.demo.controller;

import com.example.demo.model.saglasnost.Dokument;
import com.example.demo.model.saglasnost.EvidencijaOVakcinaciji;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije;
import com.example.demo.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "medic", produces = {MediaType.APPLICATION_XML_VALUE})
public class MedicController {

    @Autowired
    private MedicService service;

    @GetMapping(value="/saglasnost/{email}")
    public ResponseEntity<SaglasnostZaSprovodjenjeImunizacije> findOneByJmbg(@PathVariable String email){
        SaglasnostZaSprovodjenjeImunizacije saglasnost = service.findOneByJmbg(email);

        return new ResponseEntity<>(saglasnost, HttpStatus.OK);
    }

    @PostMapping(value="/saglasnost/{jmbg}", consumes = "application/xml")
    public ResponseEntity<Dokument> addVaccineEvidence(@PathVariable String email, @RequestBody EvidencijaOVakcinaciji evidence){
        Dokument kompletnaSaglasnost = service.addVaccineEvidenceToSaglasnost(email, evidence);

        return new ResponseEntity<>(kompletnaSaglasnost, HttpStatus.OK);
    }
}
