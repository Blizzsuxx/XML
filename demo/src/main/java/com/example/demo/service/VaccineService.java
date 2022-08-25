package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IVaccineService;
import com.example.demo.model.vakcina.Vaccine;
import com.example.demo.model.vakcina.Vaccines;
import com.example.demo.repository.VaccineRepository;

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
