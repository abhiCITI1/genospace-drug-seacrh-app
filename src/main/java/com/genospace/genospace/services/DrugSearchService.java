package com.genospace.genospace.services;

import com.genospace.genospace.models.Drug;
import com.genospace.genospace.models.Mechanism;
import com.genospace.genospace.models.Mechanism;


import java.util.List;

public interface DrugSearchService {

    public Drug findDrug(int id);
    public Drug findMechanism(int id);
    public List<Drug> findDrugs();
    public List<Mechanism> findMechanisms();
    public Drug findByDrugName(String name);
    public Mechanism findByMechanismName(String name);

}
