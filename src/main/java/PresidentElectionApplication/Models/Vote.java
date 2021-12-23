package PresidentElectionApplication.Models;

import javax.persistence.*;


@Entity
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue
    @Column(name = "vote_id")
    private int vote_id;
    @Column(name = "person_id")
    private int person_id;
    @Column(name = "candidate_number")
    private int candidate_number;

    public Vote(int person_id, int candidate_number) {
        this.person_id = person_id;
        this.candidate_number = candidate_number;
    }

    public Vote() {
    }

    public int getVote_id() {
        return vote_id;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getCandidate_number() {
        return candidate_number;
    }

    public void setCandidate_number(int candidate_number) {
        this.candidate_number = candidate_number;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "vote_id=" + vote_id +
                ", person_id='" + person_id + '\'' +
                ", candidate_number=" + candidate_number +
                '}';
    }
}
