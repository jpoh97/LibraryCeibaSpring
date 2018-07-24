package com.ceiba.library.entities.mappers;

import com.ceiba.library.entities.models.Book;
import com.ceiba.library.entities.persistencemodels.BookPersistence;

import java.util.Optional;

public class BookMapper {

    private BookMapper() {}

    public static Book getBook(Optional<BookPersistence> bookPersistence) {
        Book book = null;
        if(bookPersistence.isPresent()) {
            book = new Book(
                    bookPersistence.get().getIsbn(),
                    bookPersistence.get().getTitle(),
                    bookPersistence.get().getYear()
            );
        }
        return book;
    }

    public static BookPersistence getBookPersistence(Optional<Book> book) {
        BookPersistence bookPersistence = null;
        if (book.isPresent()) {
            bookPersistence = new BookPersistence();
            bookPersistence.setIsbn(book.get().getIsbn());
            bookPersistence.setTitle(book.get().getTitle());
            bookPersistence.setYear(book.get().getYear());
        }
        return bookPersistence;
    }

}
