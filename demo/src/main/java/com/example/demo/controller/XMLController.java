package com.example.demo.controller;


import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.IzvestajOImunizacijiDTO;
import com.example.demo.dto.SaglasnostDTO;
import com.example.demo.dto.XMLDto;
import com.example.demo.dto.ZahtevZaSertifikatDTO;
import com.example.demo.model.interesovanje.InteresovanjeZaVakcinisanje;
import com.example.demo.service.XMLService;

@RestController
@RequestMapping(value = "api/xml", produces = MediaType.APPLICATION_XML_VALUE, consumes =  MediaType.APPLICATION_XML_VALUE)
@CrossOrigin
public class XMLController {

    private XMLService xmlService;

    private XMLController(XMLService service) {
        super();
        this.xmlService = service;
    }

    @PostMapping("/podnesiZahtevZaSaglasnost")
   public ResponseEntity<Boolean> podnesiZahtevZaSaglasnost(@RequestBody InteresovanjeZaVakcinisanje dto) throws Exception{
    System.out.println("AAAAAAAAAA");
    
    return new ResponseEntity<Boolean>(this.xmlService.podnesiZahtevZaSaglasnost(dto), HttpStatus.OK);
   }


   @PostMapping("/podnesiSaglasnost")
   public ResponseEntity<Boolean> podnesiSaglasnost(@RequestBody SaglasnostDTO dto) throws Exception{
    System.out.println("AAAAAAAAAA");
    System.out.println(dto);
    return new ResponseEntity<Boolean>(this.xmlService.podnesiSaglasnost(dto), HttpStatus.OK);
   }

   @PostMapping("/podnesiZahtevZaZeleniSertifikat")
   public ResponseEntity<Boolean> podnesiZahtevZaZeleniSertifikat(@RequestBody ZahtevZaSertifikatDTO dto, @RequestHeader("Authorization") String bearerToken) throws Exception{
    System.out.println("AAAAAAAAAA");
    System.out.println(dto);
    return new ResponseEntity<Boolean>(this.xmlService.podnesiZahtevZaZeleniSertifikat(dto, bearerToken), HttpStatus.OK);
   }

   @PostMapping("/podnesiIzvestajOImunizaciji")
   public ResponseEntity<Boolean> podnesiIzvestajOImunizaciji(@RequestBody IzvestajOImunizacijiDTO dto, @RequestHeader("Authorization") String bearerToken) throws Exception{
    System.out.println("AAAAAAAAAA");
    System.out.println(dto);
    return new ResponseEntity<Boolean>(this.xmlService.podnesiIzvestajOImunizaciji(dto, bearerToken), HttpStatus.OK);
   }

   @PostMapping("/jaxBSaglasnost")
   public ResponseEntity<XMLDto> getChangedXMLJaxBSaglasnost(@RequestBody XMLDto dto) throws Exception{
       String response = xmlService.jaxBTestSaglasnost(dto);
       return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
   }

   @PostMapping("/jaxBInteresovanje")
   public ResponseEntity<XMLDto> getChangedXMLJaxBInteresovanje(@RequestBody XMLDto dto) throws Exception{
       String response = xmlService.jaxBInteresovanje(dto);
       return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
   }

   @PostMapping("/jaxBPotrvrda")
   public ResponseEntity<XMLDto> getChangedXMLJaxBPotvrda(@RequestBody XMLDto dto) throws Exception{
       String response = xmlService.jaxBTestPotvrda(dto);
       return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
   }

   @PostMapping("/jaxBIzvestaj")
   public ResponseEntity<XMLDto> getChangedXMLJaxBIzvestaj(@RequestBody XMLDto dto) throws Exception{
       String response = xmlService.jaxBTestIzvestaj(dto);
       return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
   }


   @PostMapping("/jaxBZahtevZaSertifikat")
   public ResponseEntity<XMLDto> getChangedXMLJaxBZahtev(@RequestBody XMLDto dto) throws Exception{
       String response = xmlService.jaxBTestZahtevSertifikat(dto);
       return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
   }

    @PostMapping("/jaxBDigitalni")
    public ResponseEntity<XMLDto> getChangedXMLJaxBDigitalni(@RequestBody XMLDto dto) throws Exception{
        String response = xmlService.jaxBTestZeleni(dto);
        return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
    }

    @GetMapping("fusekiSearch/{naziv}/{godina}")
    public ResponseEntity<String> searchFromRDF(@PathVariable("naziv") String naziv, @PathVariable("godina") String godina) throws IOException {
        ArrayList<String> result = xmlService.searchByMetadata(naziv, godina);
        String output = "";
        for (String r : result) {
            output += "\n" + r;
        }
        System.out.println("OUTPUT: " + output);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
    


    

    
}