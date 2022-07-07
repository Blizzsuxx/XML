package com.clerk.clerkb.service;

import com.clerk.clerkb.dto.CitizenDocuments;

public interface IDigitalCertificateService {

    CitizenDocuments getDocumentsForCitizen(String citizenId);
}
