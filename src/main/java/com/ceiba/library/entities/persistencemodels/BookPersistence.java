package com.ceiba.library.entities.persistencemodels;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="Book")
public class BookPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int year;
}
