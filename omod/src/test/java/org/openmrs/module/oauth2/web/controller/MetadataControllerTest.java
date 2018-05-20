package org.openmrs.module.oauth2.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/webModuleApplicationContext.xml")
public class MetadataControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getMetadata_shouldReturnMetadataInformation() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/oauth/metadata").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{fhirUri:http://localhost:8080/openmrs/ws/fhir,authUri:http://localhost:8080/openmrs/ws/oauth/authorize,tokenUri:http://localhost:8080/openmrs/ws/oauth/token}";

		Assert.assertEquals(expected,result.getResponse().getContentAsString());
	}

}
