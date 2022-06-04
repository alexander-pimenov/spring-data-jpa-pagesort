package ru.pimalex.springdatajpapagesort.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

    /*Эта аннотация создаст в таблице Animal солонку category_id для связи таблиц*/
    @ManyToOne
    private Category category;
}