package com.ceiba.library.entities.persistencemodels;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name="Loan")
public class LoanPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="ID_BOOK",referencedColumnName="id")
    private BookPersistence book;

    private Date requestDate;
    private Date deadline;
    private String username;
}
