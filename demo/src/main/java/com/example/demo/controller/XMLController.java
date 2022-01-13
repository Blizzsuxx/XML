package com.example.demo.controller;


import java.io.IOException;
import java.util.ArrayList;

import com.example.demo.dto.XMLDto;
import com.example.demo.service.XMLService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/xml", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
public class XMLController {

    private XMLService xmlService;

    private XMLController(XMLService service) {
        super();
        this.xmlService = service;
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