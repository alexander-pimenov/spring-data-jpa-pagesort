package ru.pimalex.springdatajpapagesort.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.pimalex.springdatajpapagesort.model.Animal;

public interface CustomAnimalRepository {
    Page<Animal> getAnimals(Pageable pageable);
}
