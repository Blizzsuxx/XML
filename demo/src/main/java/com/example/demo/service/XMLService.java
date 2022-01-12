package com.example.demo.service;

import javax.xml.bind.JAXBContext;

import com.example.demo.dto.XMLDto;
import com.example.demo.jaxb.JaxB;
import com.example.demo.model.interesovanje.InteresovanjeZaVakcinisanje;

import org.springframework.stereotype.Service;

@Service
public class XMLService {

    private final JaxB jaxB;

    public XMLService(JaxB jaxB) {
        this.jaxB = jaxB;
    }

    public String jaxBTestInteresovanje(XMLDto dto) throws Exception {
        JAXBContext context = JAXBContext.newInstance(InteresovanjeZaVakcinisanje.class);


        InteresovanjeZaVakcinisanje interesovanje = (InteresovanjeZaVakcinisanje) jaxB.unmarshall(InteresovanjeZaVakcinisanje.class, dto.getText());
        interesovanje.setLokacija("Novi Sad");
        System.out.println(interesovanje);

        return jaxB.marshall(InteresovanjeZaVakcinisanje.class, interesovanje);


    }
}