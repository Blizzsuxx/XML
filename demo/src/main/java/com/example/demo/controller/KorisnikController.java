package com.example.demo.controller;

import com.example.demo.model.korisnik.Korisnik;
import com.example.demo.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_XML_VALUE)
public class KorisnikController {

    @Autowired
    KorisnikService korisnikService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createKorisnik(@RequestBody Korisnik korisnik) {
        if (korisnikService.create(korisnik)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
