package PresidentElectionApplication.Models;

import javax.persistence.*;

@Entity
@Table(name = "Candidate")
public class Candidate {
    @Id
    @GeneratedValue
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "List_number")
    private int List_number;
    @Column(name = "agenda")
    private String agenda;

    public Candidate(String first_name, String last_name, int list_number, String agenda) {
        this.first_name = first_name;
        this.last_name = last_name;
        List_number = list_number;
        this.agenda = agenda;
    }

    public Candidate() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getList_number() {
        return List_number;
    }

    public void setList_number(int list_number) {
        List_number = list_number;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", List_number=" + List_number +
                ", agenda='" + agenda + '\'' +
                '}';
    }
}
