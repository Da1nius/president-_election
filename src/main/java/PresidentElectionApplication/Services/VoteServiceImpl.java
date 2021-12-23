package PresidentElectionApplication.Services;


import PresidentElectionApplication.Models.CandidateVotes;
import PresidentElectionApplication.Models.RegionVotes;
import PresidentElectionApplication.Models.Vote;
import PresidentElectionApplication.Repositories.CandidateRepo;
import PresidentElectionApplication.Repositories.PersonRepo;
import PresidentElectionApplication.Repositories.VoteRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service("voteService")
@Transactional
public class VoteServiceImpl implements VoteService{

    private final VoteRepo voteRepo;
    private final CandidateRepo candidateRepo;
    private final PersonRepo personRepo;

    public VoteServiceImpl(VoteRepo voteRepo, CandidateRepo candidateRepo, PersonRepo personRepo) {
        this.voteRepo = voteRepo;
        this.candidateRepo = candidateRepo;
        this.personRepo = personRepo;
    }


    @Override
    public String createVote(int person_id, int List_number) {
        try {
        if(personRepo.findbyid(person_id).equals("Yes")){
            return ("Sorry but you can't support twice!");

        }
        else if(personRepo.findbyid(person_id).equals("No")){
              voteRepo.save(new Vote(person_id,List_number));
              personRepo.updateVoted(person_id);
            return("You have voted!");

        }}catch(NullPointerException e) {
            return ("NullPointerException thrown! Wrong credentials!!");
        }

        return "Those returns will cover me :)";
    }

    @Override
    public List<CandidateVotes> getDistribution() throws SQLException {
        return  voteRepo.Distribution();
    }

    @Override
    public List<RegionVotes> RegionVotes() throws SQLException {
        return voteRepo.RegionVotes();
    }


}
