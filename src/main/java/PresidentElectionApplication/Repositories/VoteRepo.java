package PresidentElectionApplication.Repositories;

import PresidentElectionApplication.Models.Candidate;
import PresidentElectionApplication.Models.CandidateVotes;
import PresidentElectionApplication.Models.RegionVotes;
import PresidentElectionApplication.Models.Vote;
import PresidentElectionApplication.utils.DbOperations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface VoteRepo extends JpaRepository<Vote, Integer> {

     default List<CandidateVotes> Distribution() throws SQLException {
         List<CandidateVotes> candidateVotes = new ArrayList<>();
         Connection connection = DbOperations.connectToDb();
        String sql = " select candidate.first_name,last_name,List_number,agenda, Count(vote_id)\n" +
                "    from votes\n" +
                "    INNER join  candidate\n" +
                "    ON candidate.List_number=votes.candidate_number\n" +
                "    Group by candidate.first_name";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String first_name = rs.getString("candidate.first_name");
            String last_name = rs.getString("candidate.last_name");
            int List_number = rs.getInt("candidate.List_number");
            String agenda = rs.getString("candidate.agenda");
            int votes= rs.getInt("Count(vote_id)");
            candidateVotes.add(new CandidateVotes(new Candidate(first_name,last_name,List_number,agenda),votes));
        } DbOperations.disconnectFromDb(connection, ps);
        return candidateVotes;
    }

    default List<RegionVotes> RegionVotes() throws SQLException {
        List<RegionVotes> regionVotes = new ArrayList<>();
        Connection connection = DbOperations.connectToDb();
        String sql = " select person.region,Count(vote_id)\n" +
                "from votes\n" +
                "INNER join person\n" +
                "ON person.person_id=votes.person_id\n" +
                "GROUP by person.region";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String region = rs.getString("person.region");
            int votes = rs.getInt("Count(vote_id)");
            regionVotes.add(new RegionVotes(region,votes));
        } DbOperations.disconnectFromDb(connection, ps);
        return regionVotes;
    }


}
