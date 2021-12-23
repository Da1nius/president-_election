package PresidentElectionApplication.Models;

import javax.persistence.*;

@Entity
@Table(name = "Candidate")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private int person_id;
    @Column(name = "region")
    private String region;
    @Column(name = "voted")
    private String voted;


    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String isVoted() {
        return voted;
    }

    public void String(String voted) {
        this.voted = voted;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", region='" + region + '\'' +
                ", voted=" + voted +
                '}';
    }
}
