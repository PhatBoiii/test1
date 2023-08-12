package com.example.test1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;




@SpringBootTest
@AutoConfigureMockMvc
class Test1ApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void product1() throws Exception{
		ResultActions perform = mvc.perform(get("/product1").contentType(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		String contentAsString = response.getContentAsString();

		assertEquals("{\"ID\":\"1\",\"Name\":\"iPhone 15\",\"Unit Price\":\"1499.99\"}", contentAsString);
	}

	@Test
	public void product2() throws Exception{
		ResultActions perform = mvc.perform(get("/product2").contentType(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		String contentAsString = response.getContentAsString();

		assertEquals("{\"ID\":\"2\",\"Name\":\"MacBook Pro\",\"Unit Price\":\"2999.99\"}", contentAsString);
	}

}
