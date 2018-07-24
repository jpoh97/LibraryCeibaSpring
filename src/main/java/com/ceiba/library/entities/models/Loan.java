package com.ceiba.library.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class Loan {
    private Date requestDate;
    private Book book;
    private Date deadline;
    private String username;
}
