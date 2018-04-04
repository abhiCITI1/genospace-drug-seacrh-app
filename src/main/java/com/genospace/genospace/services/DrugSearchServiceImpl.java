package com.genospace.genospace.services;

import com.genospace.genospace.models.Drug;
import com.genospace.genospace.models.Mechanism;
import com.genospace.genospace.repositories.DrugRepository;
import com.genospace.genospace.repositories.MechanismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugSearchServiceImpl implements DrugSearchService{

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private MechanismRepository mechanismRepository;


    @Override
    public Drug findDrug(int id) {
        return null;
    }

    @Override
    public Drug findMechanism(int id) {
        return null;
    }

    @Override
    public List<Drug> findDrugs() {
        List<Drug> drugs = drugRepository.findAll();
        return drugs;
    }

    @Override
    public List<Mechanism> findMechanisms() {
        List<Mechanism> mechanisms = mechanismRepository.findAll();
        return mechanisms;
    }

    @Override
    public Drug findByDrugName(String name) {
        Drug drug = drugRepository.findByDrugName(name);
        return drug;
    }

    @Override
    public Mechanism findByMechanismName(String name) {
        Mechanism mechanism = mechanismRepository.findByMechanismName(name);
        return mechanism;
    }
}
