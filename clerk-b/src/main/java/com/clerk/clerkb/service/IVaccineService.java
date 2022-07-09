package com.clerk.clerkb.service;

import com.clerk.clerkb.model.vakcina.Vaccine;

public interface IVaccineService {

    Vaccine save(Vaccine vaccine);

    void updateQuantity(long vaccineId, int quantity);

    int getQuantity(long vaccineId);
}
