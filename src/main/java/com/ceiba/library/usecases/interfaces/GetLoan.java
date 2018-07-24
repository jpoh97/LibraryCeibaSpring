package com.ceiba.library.usecases.interfaces;

import com.ceiba.library.entities.models.Loan;

public interface GetLoan {
    Loan getLoanByISBN(String isbn);
}
