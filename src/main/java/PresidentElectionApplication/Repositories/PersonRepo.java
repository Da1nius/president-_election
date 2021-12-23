package PresidentElectionApplication.Repositories;

import PresidentElectionApplication.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT voted FROM election_db.person WHERE person_id = ?", nativeQuery = true)
    String findbyid(int id);
    @Modifying
    @Query(value = "UPDATE election_db.person SET voted='Yes' WHERE person_id = ?", nativeQuery = true)
    void updateVoted(int id);
}
