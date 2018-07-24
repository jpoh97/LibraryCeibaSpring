package com.ceiba.library.integration;

import com.ceiba.library.controllers.Librarian;
import com.ceiba.library.entities.mappers.BookMapper;
import com.ceiba.library.entities.models.Book;
import com.ceiba.library.entities.models.Loan;
import com.ceiba.library.entities.repositories.BookRepository;
import com.ceiba.library.entities.repositories.LoanRepository;
import com.ceiba.library.usecases.implementations.LendImplementation;
import com.ceiba.library.usecases.interfaces.GetBook;
import com.ceiba.library.usecases.interfaces.GetLoan;
import com.ceiba.library.usecases.interfaces.Lend;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibrarianTest {

    @Autowired
    Lend lendUseCase;

    @Autowired
    GetLoan getLoanUseCase;

    @Autowired
    GetBook getBookUseCase;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void lendBookTest() {
        // arrange
        Book book = new Book("123", "alv", 2018);
        Loan loan = new Loan(new Date(), book, new Date(), "alv");
        Librarian librarian = new Librarian(lendUseCase, getLoanUseCase, getBookUseCase);

        bookRepository.save(BookMapper.getBookPersistence(Optional.ofNullable(book)));

        // act
        librarian.lend(book.getIsbn(), "Juan Pablo");

        // assert
        Assert.assertTrue(librarian.isBorrowed(book.getIsbn()));
    }
}
