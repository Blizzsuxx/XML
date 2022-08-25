package com.example.demo;

import com.example.demo.model.vakcina.Vaccine;
import com.example.demo.model.vakcina.Vaccines;

public interface IVaccineService {

    Vaccine save(Vaccine vaccine);

    void updateQuantity(long vaccineId, int quantity);

    int getQuantity(long vaccineId);

    Vaccines findAll();
}
