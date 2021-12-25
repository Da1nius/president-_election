package president.election.application.services;


import president.election.application.models.CandidateVotes;
import president.election.application.models.RegionVotes;
import president.election.application.models.Vote;
import president.election.application.repositories.CandidateRepo;
import president.election.application.repositories.PersonRepo;
import president.election.application.repositories.VoteRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

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
    public List<CandidateVotes> getVotesPerCandidate() throws SQLException {
        return  voteRepo.getVotesPerCandidate();
    }

    @Override
    public List<RegionVotes> regionVotes() throws SQLException {
        return voteRepo.regionVotes();
    }


}
