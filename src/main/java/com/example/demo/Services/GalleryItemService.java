package com.example.demo.Services;

import com.example.demo.Models.GalleryItem;
import com.example.demo.Repositories.GalleryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryItemService {
    private final GalleryItemRepository repo;

    public GalleryItemService(GalleryItemRepository repo) {
        this.repo = repo;
    }

    public List<GalleryItem> getAll() {
        return repo.findAll();
    }

    public GalleryItem getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public GalleryItem save(GalleryItem item) {
        return repo.save(item);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
