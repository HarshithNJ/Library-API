package org.library.library_management.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNO;

    private String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;
    
}
