package com.ceiba.library.entities.repositories;

import com.ceiba.library.entities.persistencemodels.LoanPersistence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends CrudRepository<LoanPersistence, Long> {

    Optional<List<LoanPersistence>> findAllByBookIsbn(String isbn);

}
