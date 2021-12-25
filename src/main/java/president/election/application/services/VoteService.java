package president.election.application.services;

import president.election.application.models.CandidateVotes;
import president.election.application.models.RegionVotes;

import java.sql.SQLException;
import java.util.List;

public interface VoteService {

    String createVote(int person_id, int List_number);


    List<CandidateVotes> getVotesPerCandidate() throws SQLException;

    List<RegionVotes> regionVotes() throws SQLException;

}
