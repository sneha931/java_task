package com.example.Products.service;

import com.example.Products.models.Item;
import com.example.Products.repository.ItemRepository;
import com.example.Products.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item additem( Item item){
        return itemRepository.save(item);

    }

    public  Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }
    public List<Item> findAll(){
        return  itemRepository.findAll();
    }
}
