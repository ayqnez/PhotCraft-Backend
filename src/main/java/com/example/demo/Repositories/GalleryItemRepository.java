package com.example.demo.Repositories;

import com.example.demo.Models.GalleryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryItemRepository extends JpaRepository<GalleryItem, Integer> {
}
