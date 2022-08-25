package com.example.demo.service;

import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import com.example.demo.model.korisnik.Korisnik;
import com.example.demo.repository.KorisnikRepository;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean create(Korisnik korisnik) throws Exception {
        Korisnik korisnik2 = null;
        try{

            korisnik2 = getOne(korisnik.getEmail());
            if(korisnik2 != null){
                return false;
            }                
        } catch(Exception e){

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
