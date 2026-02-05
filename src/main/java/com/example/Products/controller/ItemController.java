package com.example.Products.controller;

import com.example.Products.models.Item;
import com.example.Products.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/")
    public Item addItem(@Valid @RequestBody Item item){
        System.out.println("adding item to list..");
        return itemService.additem(item);
    }
    @GetMapping("/{id}")
    public Optional<Item> findById(@PathVariable Long id){
        return itemService.findById(id);
    }

    @GetMapping("/")
    public List<Item> findAll(){
        return itemService.findAll();
    }
}
