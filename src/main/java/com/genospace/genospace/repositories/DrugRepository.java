package com.genospace.genospace.repositories;

import com.genospace.genospace.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface DrugRepository extends JpaRepository<Drug,Serializable>{


}
