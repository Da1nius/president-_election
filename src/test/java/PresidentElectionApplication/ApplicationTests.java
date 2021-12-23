package PresidentElectionApplication;


import PresidentElectionApplication.Services.CandidateService;
import PresidentElectionApplication.Services.VoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class,
		webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private CandidateService candidateRepo;
	@Autowired
	private VoteService voteService;

	private MockMvc mockMvc;
	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

	}

	@Test
	public void testAllCandidates() throws Exception {

		JSONParser jsonParser= new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
		ObjectMapper objectMapper = new ObjectMapper();

		JSONArray listJson = (JSONArray) jsonParser.parse(objectMapper.writeValueAsString(candidateRepo.findAll()));

		MvcResult mvcResult = this.mockMvc.perform(get("/Candidates"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("[*]").value(listJson))
				.andReturn();

		Assert.assertEquals("application/json",
				mvcResult.getResponse().getContentType());
	}
	@Test
	public void TestVotingDuplicate() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/Vote/{person_id}/{List_number}",1,2))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.response").value("Sorry but you can't support twice!"))
				.andReturn();

		Assert.assertEquals("application/json",
				mvcResult.getResponse().getContentType());
	}

	@Test
	public void TestVotingError() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/Vote/{person_id}/{List_number}",60,4))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.response").value("NullPointerException thrown! Wrong credentials!!"))
				.andReturn();

		Assert.assertEquals("application/json",
				mvcResult.getResponse().getContentType());
	}

	@Test
	public void TestVotingSuccessful() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/Vote/{person_id}/{List_number}",5,1))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.response").value("NullPointerException thrown! Wrong credentials!!"))
				.andReturn();

		Assert.assertEquals("application/json",
				mvcResult.getResponse().getContentType());
	}
}

