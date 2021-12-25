package president.election.application.services;

import president.election.application.models.Candidate;

import java.sql.SQLException;
import java.util.List;

/**
 * CandidateService interface
 */
public interface CandidateService {
    /**
     *
     * @return all candidates.
     */
    List<Candidate> findAll();

    /**
     *
     * @return winning candidates or one winner candidate.
     * @throws SQLException
     */
    List<Candidate> getWinningCandidates() throws SQLException;

}
