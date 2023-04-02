package com.example.Shop.service;

import com.example.Shop.model.Shop;

import java.util.List;

public interface ShopService {
    Shop createNewShop(Shop shop);

    List<Shop> getAllShops();

    Shop getShopById(String id);

    Shop updateShopById(String id, Shop shop);

    Shop deleteShopById(String id);

}
