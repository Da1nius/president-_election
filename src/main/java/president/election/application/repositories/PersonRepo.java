package president.election.application.repositories;

import president.election.application.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Person interface
 */
public interface PersonRepo extends JpaRepository<Person, Integer> {
    /**
     *
     * @param id
     * @return Person with id that we set.
     */
    @Query(value = "SELECT voted FROM election_db.person WHERE person_id = ?", nativeQuery = true)
    String findbyid(int id);

    /**
     * Query to update person that voted.
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE election_db.person SET voted='Yes' WHERE person_id = ?", nativeQuery = true)
    void updateVoted(int id);
}
