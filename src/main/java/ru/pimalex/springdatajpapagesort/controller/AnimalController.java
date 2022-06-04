package ru.pimalex.springdatajpapagesort.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pimalex.springdatajpapagesort.dao.AnimalRepository;
import ru.pimalex.springdatajpapagesort.model.Animal;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/animals")
    public List<Animal> findAllAnimal() {
        return animalRepository.findAll();
    }
}
