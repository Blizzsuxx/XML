package com.example.demo.service;

import com.example.demo.model.korisnik.Korisnik;
import com.example.demo.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

    @Autowired
    KorisnikRepository korisnikRepository;


    public boolean create(Korisnik korisnik) {
        return korisnikRepository.create(korisnik);
    }
}
