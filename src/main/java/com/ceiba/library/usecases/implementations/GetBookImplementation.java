package com.ceiba.library.usecases.implementations;

import com.ceiba.library.entities.mappers.BookMapper;
import com.ceiba.library.entities.models.Book;
import com.ceiba.library.entities.persistencemodels.BookPersistence;
import com.ceiba.library.entities.repositories.BookRepository;
import com.ceiba.library.usecases.interfaces.GetBook;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetBookImplementation implements GetBook {

    private BookRepository bookRepository;

    public GetBookImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Optional<BookPersistence> bookPersistence = bookRepository.findByIsbn(isbn);
        if(bookPersistence.isPresent()) {
            return BookMapper.getBook(bookPersistence);
        }
        return null;
    }
}
