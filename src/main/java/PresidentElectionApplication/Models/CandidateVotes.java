package PresidentElectionApplication.Models;

import java.util.List;

public class CandidateVotes {
    private Candidate candidate;
    private int  votes;

    public CandidateVotes(Candidate candidate, int votes) {
        this.candidate = candidate;
        this.votes = votes;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "CandidateVotes{" +
                "candidate=" + candidate +
                ", votes=" + votes +
                '}';
    }
}
