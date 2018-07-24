package com.ceiba.library.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private int year;
}
