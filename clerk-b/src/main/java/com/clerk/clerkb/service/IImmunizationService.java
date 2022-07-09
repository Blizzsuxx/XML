package com.clerk.clerkb.service;

import com.clerk.clerkb.model.izvestajOImunizaciji.IzvestajOImunizaciji;

public interface IImmunizationService {

    IzvestajOImunizaciji createImmunizationReport(String dateFrom, String dateUntil);
}
