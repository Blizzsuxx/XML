package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.korisnik.Korisnik;
import com.example.demo.service.KorisnikService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_XML_VALUE)
@CrossOrigin
public class KorisnikController {

    @Autowired
    KorisnikService korisnikService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createKorisnik(@RequestBody Korisnik korisnik) throws Exception {
        System.out.println(korisnik.toString());
        if (korisnikService.create(korisnik)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<?> getOneKorisnik(@PathVariable("email") String email) throws Exception {
         Korisnik korisnik = korisnikService.getOne(email.replace("-","."));
         if (korisnik != null) {
             return new ResponseEntity<>(korisnik, HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
