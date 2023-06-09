package com.mnst.minsaitProject.testAT.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Steps for Price API REST scenarios
 *
 * @author tlorenzo
 */
public class Steps {

	private static final String BASE_URL = "http://localhost:8080";
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private Response response;

	@Given("^the application with running status$")
	public void apiRestEnEjecucion() {
		RestAssured.baseURI = BASE_URL;
	}

	@When("^the endpoint is called with the method GET and with the parameters (.*), (\\d+) and (\\d+)$")
	public void solicitudGETAlEndpoint(String applicationDate, Long productId, Long brandId) {
		response = given().basePath("/v1/price").param("applicationDate", applicationDate).param("productId", productId)
				.param("brandId", brandId).get();
	}

	@Then("^the response code must be (\\d+)$")
	public void theResponseCodeMustBe(int responseCode) {
		response.then().assertThat().statusCode(responseCode);
	}

	@And("^the response body must be (.*)$")
	public void theResponseBodyMustBe(String bodyPath) throws IOException {
		String responseBodyFile = "com/mnst/minsaitProject/testAT/response/" + bodyPath;
		InputStream inputStream = Steps.class.getClassLoader().getResourceAsStream(responseBodyFile);
		JsonNode expected = OBJECT_MAPPER.readTree(inputStream);
		JsonNode actual = OBJECT_MAPPER.readTree(response.getBody().asString());

		assertNotNull(expected);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

}
