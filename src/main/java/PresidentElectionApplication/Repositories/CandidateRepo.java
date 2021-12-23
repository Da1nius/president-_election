package PresidentElectionApplication.Repositories;

import PresidentElectionApplication.Models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
}
