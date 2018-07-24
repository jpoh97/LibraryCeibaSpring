package com.ceiba.library.usecases.implementations;

import com.ceiba.library.entities.mappers.LoanMapper;
import com.ceiba.library.entities.models.Loan;
import com.ceiba.library.entities.persistencemodels.LoanPersistence;
import com.ceiba.library.entities.repositories.LoanRepository;
import com.ceiba.library.usecases.interfaces.GetLoan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GetLoanImplementation implements GetLoan {

    private LoanRepository loanRepository;

    public GetLoanImplementation(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan getLoanByISBN(String isbn) {
        Optional<List<LoanPersistence>> loanPersistence = loanRepository.findAllByBookIsbn(isbn);
        if (loanPersistence.isPresent()) {
            return LoanMapper.getLoan(Optional.ofNullable(loanPersistence.get().get(0)));
        }
        return null;
    }
}
