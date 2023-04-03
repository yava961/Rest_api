package com.example.Shop.service;

import com.example.Shop.model.Shop;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {
    private Map<String, Shop> db = new HashMap<>();

    @Override
    public Shop createNewShop(Shop shop) {
        return db.put(shop.getId(), shop);
    }

    @Override
    public List<Shop> getAllShops() {
        return new ArrayList<>(db.values());
    }

    @Override
    public Shop getShopById(String id) {
        return db.get(id);
    }

    @Override
    public Shop updateShopById(String id, Shop shop) {
        shop.setId(id);
        return db.put(id, shop);
    }

    @Override
    public Shop deleteShopById(String id) {
        return db.remove(id);
    }
}
