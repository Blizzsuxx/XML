package com.clerk.clerkb.service.impl;

import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import com.clerk.clerkb.model.korisnik.Korisnik;
import com.clerk.clerkb.repository.KorisnikRepository;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;



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
