package com.ceiba.library.usecases.interfaces;

import com.ceiba.library.entities.models.Book;

public interface GetBook {
    Book getBookByIsbn(String isbn);
}
