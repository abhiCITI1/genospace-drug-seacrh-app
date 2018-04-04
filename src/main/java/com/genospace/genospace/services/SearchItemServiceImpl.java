package com.genospace.genospace.services;


import com.genospace.genospace.models.SearchItem;
import com.genospace.genospace.repositories.SearchItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchItemServiceImpl implements SearchItemService{

    @Autowired
    private SearchItemRepository searchItemRepository;

    @Override
    public List<SearchItem> findItems() {

        List<SearchItem> items = searchItemRepository.findAll();
        return items;
    }

    @Override
    public List<SearchItem> findByItemNameLike(String matchingChar) {

        List<SearchItem> items = searchItemRepository.findByItemNameStartingWith(matchingChar);
        return items;
    }
}
