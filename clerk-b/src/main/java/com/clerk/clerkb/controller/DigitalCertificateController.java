package com.clerk.clerkb.controller;

import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.service.IDigitalCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cert", produces = MediaType.APPLICATION_XML_VALUE)
public class DigitalCertificateController {

    @Autowired
    private IDigitalCertificateService service;

    @GetMapping(value = "/all-citizen/{citizenId}", produces = "application/xml")
    public ResponseEntity<CitizenDocuments> getAllDocumentsForCitizen(@PathVariable String citizenId){
        CitizenDocuments cd = service.getDocumentsForCitizen(citizenId);
        return new ResponseEntity<>(cd, HttpStatus.OK);
    }

    @PostMapping(value = "/decline/{reason}") //requestId?
    public ResponseEntity<String> declineCertificateRequest(@PathVariable String reason){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/approve") //requestId?
    public ResponseEntity<String> acceptCertificateRequest(){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
