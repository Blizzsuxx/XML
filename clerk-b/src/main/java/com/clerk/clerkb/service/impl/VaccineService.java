package com.clerk.clerkb.service.impl;

import com.clerk.clerkb.model.vakcina.Vaccine;
import com.clerk.clerkb.model.vakcina.Vaccines;
import com.clerk.clerkb.repository.VaccineRepository;
import com.clerk.clerkb.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VaccineService implements IVaccineService {

    @Autowired
    private VaccineRepository repository;

    @Override
    public Vaccine save(Vaccine vaccine) {
        return repository.save(vaccine);
    }

    @Override
    public void updateQuantity(long vaccineId, int quantity) {
        repository.updateQuantity(vaccineId, quantity);
    }

    @Override
    public int getQuantity(long vaccineId){
        Vaccine found = repository.findById(vaccineId);
        return found.getQuantity();
    }

    @Override
    public Vaccines findAll() {
        Vaccines vaccines = new Vaccines();
        List<Vaccine> vaccineList = repository.findAll();
        vaccines.setVaccine(vaccineList);
        return vaccines;
    }
}
