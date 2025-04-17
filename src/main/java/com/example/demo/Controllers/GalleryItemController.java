package com.example.demo.Controllers;

import com.example.demo.Models.GalleryItem;
import com.example.demo.Services.GalleryItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin
public class GalleryItemController {
    private final GalleryItemService service;

    public GalleryItemController(GalleryItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<GalleryItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GalleryItem getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public GalleryItem create(@RequestBody GalleryItem item) {
        return service.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
