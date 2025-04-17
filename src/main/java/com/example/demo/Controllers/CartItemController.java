// CartItemController.java
package com.example.demo.Controllers;

import com.example.demo.Models.CartItem;
import com.example.demo.Services.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartItemController {
    private final CartItemService service;

    public CartItemController(CartItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<CartItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CartItem getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CartItem create(@RequestBody CartItem item) {
        return service.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
