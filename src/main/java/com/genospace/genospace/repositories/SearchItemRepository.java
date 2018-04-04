package com.genospace.genospace.repositories;


import com.genospace.genospace.models.SearchItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.naming.directory.SearchControls;
import java.io.Serializable;
import java.util.List;

@Repository
public interface SearchItemRepository extends JpaRepository<SearchItem, Serializable>{

    public String findById(String id);

    public List<SearchItem> findByItemNameStartingWith(String name);




}
