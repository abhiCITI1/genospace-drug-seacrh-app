package com.genospace.genospace.models;


import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "Search_Item")
public class SearchItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_category")
    private String itemCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }
}
