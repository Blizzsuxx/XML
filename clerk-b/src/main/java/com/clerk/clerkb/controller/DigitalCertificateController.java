package com.clerk.clerkb.controller;

import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahteviZaSertifikat;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import com.clerk.clerkb.service.IDigitalCertificateService;
import com.clerk.clerkb.service.impl.DocumentTransformerService;
import org.apache.regexp.RE;
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

    @GetMapping(value ="/requests")
    public ResponseEntity<ZahteviZaSertifikat> getAllCertificateRequests(){
        try{
            return new ResponseEntity<>(service.findAllRequests(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/transform-interesovanje/{id}")
    public ResponseEntity<String> transformInteresovanje(@PathVariable String id){
        System.out.println("OK");
        try{
            String html = service.findInteresovanje(id);
            return new ResponseEntity<>(html, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/transform-request/{id}")
    public ResponseEntity<String> transformRequest(@PathVariable String id){
        System.out.println("OK");
        try{
            String html = service.findRequestById(id);
            return new ResponseEntity<>(html, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/transform-saglasnost/{id}")
    public ResponseEntity<String> transformSaglasnost(@PathVariable String id){
        System.out.println("OK");
        try{
            String html = service.findSaglasnostById(id);
            return new ResponseEntity<>(html, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/transform-certificate/{id}")
    public ResponseEntity<String> transformCertificate(@PathVariable String id){
        System.out.println("OK");
        try {
            String content = service.generateCertificateView(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
