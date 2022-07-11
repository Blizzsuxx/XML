package com.clerk.clerkb.service;

import com.clerk.clerkb.model.vakcina.Vaccine;
import com.clerk.clerkb.model.vakcina.Vaccines;

public interface IVaccineService {

    Vaccine save(Vaccine vaccine);

    void updateQuantity(long vaccineId, int quantity);

    int getQuantity(long vaccineId);

    Vaccines findAll();
}
