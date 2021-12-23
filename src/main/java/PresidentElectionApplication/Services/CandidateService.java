package PresidentElectionApplication.Services;

import PresidentElectionApplication.Models.Candidate;

import java.sql.SQLException;
import java.util.List;

public interface CandidateService {

    List<Candidate> findAll();

    List<Candidate> getWinningCandidates() throws SQLException;

}
