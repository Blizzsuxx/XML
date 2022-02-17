package com.example.demo.service;

import com.example.demo.model.korisnik.Korisnik;
import com.example.demo.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean create(Korisnik korisnik) throws Exception {
        if (getOne(korisnik.getEmail()) != null ) {
            return false;
        }

        korisnik.setLozinka(passwordEncoder.encode(korisnik.getLozinka()));

        return korisnikRepository.create(korisnik);
    }

    public Korisnik getOne(String email) throws Exception {
        XMLResource resource = korisnikRepository.getOne(email);

        if (resource == null) {
            return null;
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
        Korisnik korisnik = (Korisnik) jaxbContext.createUnmarshaller().unmarshal(resource.getContentAsDOM());

        return korisnik;

    }
}
