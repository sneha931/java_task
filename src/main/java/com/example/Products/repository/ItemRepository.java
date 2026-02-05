package com.example.Products.repository;

import com.example.Products.models.Item;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private final List<Item> items=new ArrayList<>();
    private Long id = 1L;

    public Item save(Item item){
        item.setId(id++);
        items.add(item);
        return item;
    }

    public Optional<Item> findById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public List<Item> findAll(){
        return items;
    }
}
