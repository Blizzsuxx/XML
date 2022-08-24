package com.clerk.clerkb.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.dto.EvidencijaDTO;
import com.clerk.clerkb.model.saglasnost.Dokument;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahteviZaSertifikat;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import com.google.zxing.WriterException;

public interface IDigitalCertificateService {

    CitizenDocuments getDocumentsForCitizen(String citizenId);

    void declineCertificateRequest(String requestId, String reason) throws Exception;

    DigitalniSertifikat acceptCertificateRequest(String requestId) throws Exception;

    ZahteviZaSertifikat findAllRequests();

    String findRequestById(String id) throws FileNotFoundException;

    String findSaglasnostById(String id) throws FileNotFoundException;

    String generateCertificateView(String id, String content) throws IOException, WriterException;

    String findInteresovanje(String id) throws FileNotFoundException;

    String findPotvrdaById(String id) throws FileNotFoundException;
    
    Dokument findSaglasnostByIdDocument(String id) throws FileNotFoundException, JAXBException;

    Boolean dodajEvidenciju(EvidencijaDTO evidencija, String jmbg) throws Exception;
}
