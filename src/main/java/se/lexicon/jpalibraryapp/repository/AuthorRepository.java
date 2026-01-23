package se.lexicon.jpalibraryapp.repository;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import se.lexicon.jpalibraryapp.entity.Author;
import se.lexicon.jpalibraryapp.entity.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // Find by first name
    List<Author> findByFirstName(String firstName);

    // Find by last name
    List<Author> findByLastName(String lastName);

    // Find by first name or last name containing a keyword
    List<Author> findByFirstNameOrLastNameContains(String firstName, String lastName);

    // Find by a book's ID
    List<Author> findByWrittenBooks_Id(int id);

    // Update name by ID
    @Modifying
    @Query("UPDATE Author a SET a.firstName = ?1, a.lastName = ?2 WHERE a.id = ?3")
    int updateName(String firstName, String lastName, int id);

    // Delete by ID
    void deleteById(int id);
}