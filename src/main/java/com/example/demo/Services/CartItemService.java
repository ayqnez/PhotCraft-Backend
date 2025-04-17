// CartItemService.java
package com.example.demo.Services;

import com.example.demo.Models.CartItem;
import com.example.demo.Repositories.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final CartItemRepository repo;

    public CartItemService(CartItemRepository repo) {
        this.repo = repo;
    }

    public List<CartItem> getAll() {
        return repo.findAll();
    }

    public CartItem getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public CartItem save(CartItem item) {
        return repo.save(item);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
