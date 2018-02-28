package br.com.campanha.restful.integration.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;


import br.com.campanha.restful.model.Campanha;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
@Sql({ "classpath:init-data.sql" })
public class CampanhaControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	private static final String URL = "/campanha/";

	@Test
	public void testAddCampanha() throws Exception {

		Campanha campanha = new Campanha("Promocao", "13", "12/06/2019");

		ResponseEntity<Campanha> responseEntity = restTemplate.postForEntity(URL,campanha,Campanha.class);

		int status = responseEntity.getStatusCodeValue();
		Campanha resultCampanha = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.CREATED.value(), status);

		assertNotNull(resultCampanha);
		assertNotNull(resultCampanha.getId().longValue());

	}

	@Test
	public void testGetCampanha() throws Exception {

		ResponseEntity<Campanha> responseEntity = restTemplate.getForEntity(URL + "{id}", Campanha.class,new Long(1));

		int status = responseEntity.getStatusCodeValue();
		Campanha resultCampanha = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);

		assertNotNull(resultCampanha);
		assertEquals(1l, resultCampanha.getId().longValue());

	}

	@Test
	public void testGetCampanhaNotExist() throws Exception {

		ResponseEntity<Campanha> responseEntity = restTemplate.getForEntity(URL + "{id}", Campanha.class,new Long(100));

		int status = responseEntity.getStatusCodeValue();
		Campanha resultCampanha = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND.value(), status);
		assertNull(resultCampanha);
	}

	@Test
	public void testGetAllCampanha() throws Exception {

		ResponseEntity<List> responseEntity = restTemplate.getForEntity(URL,List.class);

		int status = responseEntity.getStatusCodeValue();
		List<Campanha> campListResult = null;
		if (responseEntity.getBody() != null) {
			campListResult = responseEntity.getBody();
		}

		assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);

		assertNotNull("Campanhas not found", campListResult);
		assertEquals("Incorrect Campanha List", 1, campListResult.size());

	}

	@Test
	public void testDeleteCampanha() throws Exception {

		ResponseEntity<Void> responseEntity = restTemplate.exchange(URL + "{id}",HttpMethod.DELETE, null, Void.class,new Long(1));

		int status = responseEntity.getStatusCodeValue();
		assertEquals("Incorrect Response Status", HttpStatus.GONE.value(), status);

	}

	@Test
	public void testUpdateCampanha() throws Exception {
		Campanha campanha = new Campanha(1l, "Promocao", "13", "12/06/2019");
		
		HttpEntity<Campanha> requestEntity = new HttpEntity<Campanha>(campanha);

		ResponseEntity<Void> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, Void.class);

		int status = responseEntity.getStatusCodeValue();
		assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
	}

}
