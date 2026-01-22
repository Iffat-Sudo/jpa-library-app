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

    List<Author> findByFirstName(String firstName);

    List<Author> findByLastName(String lastName);

    List<Author> findByFirstNameOrLastNameContains(String firstName, String lastName);

    List<Author>findByWrittenBooks_Id(Integer id);

    @Modifying
    @Query("UPDATE Author a SET a.firstName = ?1, a.lastName= ?2 WHERE a.id = ?3")
    int updateName(String firstName, String lastName, Integer id);
    void deletedById(int id);

}