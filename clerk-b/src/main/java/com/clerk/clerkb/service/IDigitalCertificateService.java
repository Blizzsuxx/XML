package com.clerk.clerkb.service;

import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahteviZaSertifikat;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import com.google.zxing.WriterException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IDigitalCertificateService {

    CitizenDocuments getDocumentsForCitizen(String citizenId);

    void declineCertificateRequest(String requestId, String reason) throws Exception;

    DigitalniSertifikat acceptCertificateRequest(String requestId) throws Exception;

    ZahteviZaSertifikat findAllRequests();

    String findRequestById(String id) throws FileNotFoundException;

    String findSaglasnostById(String id) throws FileNotFoundException;

    String generateCertificateView(String id) throws IOException, WriterException;

    String findInteresovanje(String id) throws FileNotFoundException;
}
