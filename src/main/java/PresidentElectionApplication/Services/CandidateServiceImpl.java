package PresidentElectionApplication.Services;

import PresidentElectionApplication.Models.Candidate;
import PresidentElectionApplication.Models.CandidateVotes;
import PresidentElectionApplication.Repositories.CandidateRepo;
import PresidentElectionApplication.Repositories.VoteRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.*;

@Service("candidateService")
@Transactional
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepo candidateRepo;
    private final VoteRepo voteRepo;

    public CandidateServiceImpl(CandidateRepo candidateRepo, VoteRepo voteRepo) {
        this.candidateRepo = candidateRepo;
        this.voteRepo = voteRepo;
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepo.findAll();
    }

    @Override
    public List<Candidate> getWinningCandidates() throws SQLException {
        List<Candidate> winners = new ArrayList<>();
        for (CandidateVotes candidateVotes : voteRepo.Distribution()) {
            double candidateVotePercentage = ((double) candidateVotes.getVotes() / TotalVotes()) * 100;
            if (candidateVotePercentage > 50.0f || candidateVotes.getVotes() / TotalVotes() > TotalVotes() / 2) {
                System.out.println("We found absolute winner!");
                System.out.println(candidateVotes.getCandidate());
                winners.add(candidateVotes.getCandidate());
                break;
            }
            if(SecondHighest().size()==0){
                winners.add(candidateVotes.getCandidate());
                System.out.println("We need a tie break!!!");

            }
            else if(candidateVotes.getVotes()>SecondHighest().last()){
                winners.add(candidateVotes.getCandidate());
                System.out.println("We found first place winner!");
                System.out.println(candidateVotes.getCandidate());
            }
            else if(candidateVotes.getVotes()==SecondHighest().last()){
                winners.add(candidateVotes.getCandidate());
                System.out.println("We found second place winner!");
                System.out.println(candidateVotes.getCandidate());
            }

            System.out.println(SecondHighest());
            System.out.println(candidateVotePercentage);

        }

        System.out.println(TotalVotes());
        return winners;
    }

    public int TotalVotes() {
        return voteRepo.findAll().size();
    }

    public SortedSet<Integer> SecondHighest() throws SQLException {
        int[] randomIntegers = new int[candidateRepo.findAll().size()];
        int n = 0;
        for (CandidateVotes candidateVotes : voteRepo.Distribution()) {
            randomIntegers[n] = candidateVotes.getVotes();
            n++;
        }
        SortedSet<Integer> set = new TreeSet<Integer>();
        for (int i : randomIntegers) {
            set.add(i);
        }
// Remove the maximum value; print the largest remaining item
        set.remove(set.last());
            return  set;
    }
}
