package com.example.demo.Controllers;
import com.example.demo.Models.Vacancy;
import com.example.demo.Services.VacancyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
@CrossOrigin(origins = "http://localhost:3000")
public class VacancyController {
    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping
    public List<Vacancy> getAllVacancies() {
        return vacancyService.getAllVacancies();
    }

    @PostMapping
    public Vacancy createVacancy(@RequestBody Vacancy vacancy) {
        return vacancyService.createVacancy(vacancy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVacancy(@PathVariable Long id) {
        try {
            vacancyService.deleteVacancy(id);
            return ResponseEntity.ok("Vacancy deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting vacancy");
        }
    }
}