package com.ceiba.library.usecases.implementations;

import com.ceiba.library.entities.mappers.LoanMapper;
import com.ceiba.library.entities.models.Loan;
import com.ceiba.library.entities.persistencemodels.LoanPersistence;
import com.ceiba.library.entities.repositories.LoanRepository;
import com.ceiba.library.usecases.interfaces.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class LendImplementation implements Lend {

    private LoanRepository loanRepository;

    public LendImplementation(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void lendABook(Loan loan) {
        LoanPersistence loanPersistence = LoanMapper.getLoanPersistence(Optional.ofNullable(loan));
        loanRepository.save(loanPersistence);
    }
}
