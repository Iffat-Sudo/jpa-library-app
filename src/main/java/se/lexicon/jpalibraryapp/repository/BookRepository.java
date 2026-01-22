package se.lexicon.jpalibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.jpalibraryapp.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByIsbn(String isbn);

    List<Book> findByTitleContaining(String title);
    List<Book>findByMaxLoanDaysIsLessThan(int days);

}



