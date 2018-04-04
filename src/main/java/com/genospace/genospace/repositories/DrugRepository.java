package com.genospace.genospace.repositories;

import com.genospace.genospace.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public interface DrugRepository extends JpaRepository<Drug,Serializable>{

   //@Query("select s from Drug s where s.drugName=?")
    public Drug findByDrugName(String drugName);


}
