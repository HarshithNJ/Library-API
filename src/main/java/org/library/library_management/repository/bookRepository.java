package org.library.library_management.repository;

import java.util.List;
import java.util.Optional;

import org.library.library_management.dto.book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<book, Integer>{

    boolean existsByBookId(String bookId);

    Optional<book> findByBookId(String bookId);

    List<book> findByIsAvailable(boolean isAvailable);

}
