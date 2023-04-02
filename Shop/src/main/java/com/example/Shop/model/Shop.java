package com.example.Shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Shop {
    private String id;
    private String street;
    private String city;
    private String name;
    private int numberOfEmployees;
    private boolean hasWebsite;
}
