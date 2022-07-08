package com.clerk.clerkb.controller;

import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
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

    @PostMapping(value = "/decline/{requestId}/{reason}") //requestId?
    public ResponseEntity<?> declineCertificateRequest(@PathVariable String requestId, @PathVariable String reason){
        try{
            service.declineCertificateRequest(requestId, reason);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/approve/{requestId}") //requestId?
    public ResponseEntity<DigitalniSertifikat> acceptCertificateRequest(@PathVariable String requestId){
        try {
            DigitalniSertifikat ds = service.acceptCertificateRequest(requestId);
            return new ResponseEntity<>(ds, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
