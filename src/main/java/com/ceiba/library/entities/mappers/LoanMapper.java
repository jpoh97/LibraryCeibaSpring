package com.ceiba.library.entities.mappers;

import com.ceiba.library.entities.models.Loan;
import com.ceiba.library.entities.persistencemodels.LoanPersistence;

import java.util.Optional;

public class LoanMapper {

    private LoanMapper() {}

    public static Loan getLoan(Optional<LoanPersistence> loanPersistence) {
        Loan loan = null;
        if (loanPersistence.isPresent()) {
            loan = new Loan(
                    loanPersistence.get().getRequestDate(),
                    BookMapper.getBook(Optional.ofNullable(loanPersistence.get().getBook())),
                    loanPersistence.get().getDeadline(),
                    loanPersistence.get().getUsername()
            );
        }
        return loan;
    }

    public static LoanPersistence getLoanPersistence(Optional<Loan> loan) {
        LoanPersistence loanPersistence = null;
        if (loan.isPresent()) {
            loanPersistence = new LoanPersistence();
            loanPersistence.setBook(BookMapper.getBookPersistence(Optional.ofNullable(loan.get().getBook())));
            loanPersistence.setDeadline(loan.get().getDeadline());
            loanPersistence.setRequestDate(loan.get().getRequestDate());
            loanPersistence.setUsername(loan.get().getUsername());
        }
        return loanPersistence;
    }
}
