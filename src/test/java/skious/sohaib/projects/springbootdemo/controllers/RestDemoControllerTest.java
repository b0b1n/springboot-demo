package skious.sohaib.projects.springbootdemo.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = RestDemoController.class)
public class RestDemoControllerTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	public void setupMock() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
    public void shouldReturnTwoEntitiesInitializedByDefault()
      throws Exception { 
        MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
        		MediaType.APPLICATION_JSON.getSubtype());
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/entities")).
	        andExpect(MockMvcResultMatchers.status().isOk()).
	        andExpect(MockMvcResultMatchers.content().contentType(contentType)).
	        andExpect(jsonPath("$", Matchers.hasSize(2))); 
    } 
}
