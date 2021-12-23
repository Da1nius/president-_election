package PresidentElectionApplication.Services;

import PresidentElectionApplication.Models.CandidateVotes;
import PresidentElectionApplication.Models.RegionVotes;

import java.sql.SQLException;
import java.util.List;

public interface VoteService {

    String createVote(int person_id, int List_number);


    List<CandidateVotes> getDistribution() throws SQLException;

    List<RegionVotes> RegionVotes() throws SQLException;
}
