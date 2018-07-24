package com.ceiba.library.entities.repositories;

import com.ceiba.library.entities.persistencemodels.BookPersistence;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<BookPersistence, Long> {

    Optional<BookPersistence> findByIsbn(String isbn);

}
