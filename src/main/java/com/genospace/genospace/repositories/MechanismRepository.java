package com.genospace.genospace.repositories;

import com.genospace.genospace.models.Mechanism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public interface MechanismRepository extends JpaRepository<Mechanism,Serializable>{

    public Mechanism findByMechanismName(String name);
}
