package com.example.Shop.controllers;

import com.example.Shop.model.Shop;
import com.example.Shop.service.ShopServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {
    private ShopServiceImpl shopService;

    public ShopController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop){
        try{
            Shop newShop = shopService.createNewShop(shop);
            return new ResponseEntity(newShop, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops(){
        try {
            List<Shop> shops = shopService.getAllShops();
            return new ResponseEntity(shops,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable("id") String id){
        try {
            Shop shopId = shopService.getShopById(id);
            return new ResponseEntity(shopId,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShopById(@PathVariable("id") String id,@RequestBody Shop shop){
        try {
        Shop updateShop = shopService.updateShopById(id, shop);
        return new ResponseEntity(updateShop,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> deleteShopById(@PathVariable("id") String id){
        try {
            Shop deleteShop = shopService.deleteShopById(id);
            return new ResponseEntity(deleteShop,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
