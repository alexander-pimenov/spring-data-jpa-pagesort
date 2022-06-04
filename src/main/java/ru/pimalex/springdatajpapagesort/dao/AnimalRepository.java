package ru.pimalex.springdatajpapagesort.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pimalex.springdatajpapagesort.model.Animal;

import java.util.List;

/* Для постраничного вывода элементов в параметр метода передается объект Pageable.
 * Он содержит информацию о номере запрашиваемой страницы и о количестве элементов на странице.
 * Страницы нумеруются с нуля. Ниже показан запрос первой страницы, на каждой странице два элемента:
 * Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
 *
 * В объекте Pageable можно задать заодно и сортировку. Так что элементы и сортируются, и выдаются
 * постранично. Для этого используем третий параметр — Sort:
 * PageRequest.of(0, 2, Sort.by("name").descending());
 *
 * Как видно, во всех методах есть параметр Pageable — запрос страницы.
 * При этом:
 *
 * Производные от имени запросы работают.
 * Возвращать можно как List, так и Page.
 * Работают @Query с JPQL.
 * Работают нативные @Query.
 * @Query могут быть сложные, с группировкой.*/
public interface AnimalRepository extends JpaRepository<Animal, Long>, CustomAnimalRepository {

    List<Animal> findAllByNameContaining(String str, Pageable pageable);

    Page<Animal> findAllByName(String name, Pageable pageable);

    @Query("select a from Animal a")
    Page<Animal> findAllAnimals(Pageable pageable);

    @Query(value = "select * from animal", nativeQuery = true)
    Page<Animal> findAllAnimalsNative(Pageable pageable);

    @Query(value = "select count(animal.id) as animalsCount, category.name as categoryName " +
            "from animal " +
            "join category on animal.category_id=category.id " +
            "group by category.name",
            nativeQuery = true)
    List<CountView> findAnimalsCountByCategoryNative(Pageable pageable);
}