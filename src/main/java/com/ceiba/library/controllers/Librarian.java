package com.ceiba.library.controllers;

import com.ceiba.library.entities.models.Book;
import com.ceiba.library.entities.models.Loan;
import com.ceiba.library.usecases.interfaces.GetBook;
import com.ceiba.library.usecases.interfaces.GetLoan;
import com.ceiba.library.usecases.interfaces.Lend;

import java.util.Date;
import java.util.Optional;

public class Librarian {

    Lend lendUseCase;
    GetLoan getLoanUseCase;
    GetBook getBookUseCase;

    public Librarian(Lend lendUseCase, GetLoan getLoanUseCase, GetBook getBookUseCase) {
        this.lendUseCase = lendUseCase;
        this.getLoanUseCase = getLoanUseCase;
        this.getBookUseCase = getBookUseCase;
    }

    public void lend(String isbn, String userWhoLoans) {
        Loan loan;
        Book book;
        Date loanDate;
        Date deadline = null;

        if (isBorrowed(isbn)) {
            System.out.println("Book not available");
        }

        book = getBookUseCase.getBookByIsbn(isbn);

        loan = new Loan(new Date(), book, new Date(), userWhoLoans);
        lendUseCase.lendABook(loan);
    }

    public boolean isBorrowed(String isbn) {
        if (Optional.ofNullable(isbn).isPresent()) {
            return Optional.ofNullable(getLoanUseCase.getLoanByISBN(isbn)).isPresent();
        }
        return false;
    }
}
