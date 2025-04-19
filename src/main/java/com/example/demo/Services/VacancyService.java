package com.example.demo.Services;
import com.example.demo.Models.Vacancy;
import com.example.demo.Repositories.VacancyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {
    private final VacancyRepository vacancyRepository;

    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    public Vacancy createVacancy(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        vacancyRepository.deleteById(id);
    }
}