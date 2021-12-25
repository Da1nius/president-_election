package president.election.application.repositories;

import president.election.application.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * CandidateRepository
 */
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
}
