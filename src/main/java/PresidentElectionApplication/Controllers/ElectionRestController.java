package PresidentElectionApplication.Controllers;


import PresidentElectionApplication.Models.Candidate;
import PresidentElectionApplication.Models.CandidateVotes;
import PresidentElectionApplication.Models.RegionVotes;
import PresidentElectionApplication.Services.CandidateService;
import PresidentElectionApplication.Services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class ElectionRestController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private  VoteService voteService;


    public ElectionRestController(CandidateService candidateService, VoteService voteService) {
        this.candidateService = candidateService;
        this.voteService = voteService;
    }

    @RequestMapping(value = "/Vote/{person_id}/{List_number}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> vote(@PathVariable("person_id") int person_id, @PathVariable("List_number") int List_number) throws SQLException {

        return Collections.singletonMap("response",voteService.createVote(person_id,List_number));
    }
    @RequestMapping(value = "/Candidates", method = RequestMethod.GET,  produces = "application/json")
    public List<Candidate> candidates (){
        return candidateService.findAll();
    }

    @RequestMapping(value = "/VoteDistribution", method = RequestMethod.GET,  produces = "application/json")
    public List<CandidateVotes> candidateVotes () throws SQLException {
        return voteService.getDistribution();
    }

    @RequestMapping(value = "/RegionVotes", method = RequestMethod.GET,  produces = "application/json")
    public List<RegionVotes> regionVotes () throws SQLException {
        return voteService.RegionVotes();
    }
    @RequestMapping(value = "/Winners", method = RequestMethod.GET,  produces = "application/json")
    public List<Candidate> Winners () throws SQLException {
        return candidateService.getWinningCandidates();
    }



}
