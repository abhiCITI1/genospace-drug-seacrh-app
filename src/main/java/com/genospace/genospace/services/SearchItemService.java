package com.genospace.genospace.services;


import com.genospace.genospace.models.SearchItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchItemService {

    public List<SearchItem> findItems();

    public List<SearchItem> findByItemNameLike(String matchingChar);
}
