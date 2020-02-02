package com.example.Songr2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class Songr2ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private HomeController homeController;

	@Test
	void contextLoads() {
	}

	@Test
	public void helloWorldTest() throws Exception {
		this.mockMvc.perform(get("/helloworld"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World!")));
	}

}
