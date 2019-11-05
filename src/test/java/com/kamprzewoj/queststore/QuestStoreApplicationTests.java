package com.kamprzewoj.queststore;

import com.kamprzewoj.queststore.security.JWT.LoginViewModel;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;



import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;


//todo https://dzone.com/articles/how-to-create-rest-api-with-spring-boot


@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuestStoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class QuestStoreApplicationTests {

	private String token;

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl(){
		return "https://localhost:" + port;
	}

	@Test
	public void url(){
		Assert.assertEquals("https://localhost:8443", getRootUrl());
	}

	@Test
	public void login() throws URISyntaxException {
		String baseUrl = getRootUrl() + "/login";
		URI uri = new URI(baseUrl);

		HttpHeaders httpHeaders = new HttpHeaders();
		LoginViewModel loginViewModel = new LoginViewModel();
		loginViewModel.setUsername("root");
		loginViewModel.setPassword("root");

		HttpEntity<LoginViewModel> request = new HttpEntity<>(loginViewModel, httpHeaders);
		ResponseEntity<String> stringResponseEntity = this.restTemplate.postForEntity(uri, request, String.class);

		Assert.assertEquals(200, stringResponseEntity.getStatusCodeValue());
		token = Objects.requireNonNull(stringResponseEntity.getHeaders().get("Authorization")).get(0);

		httpHeaders.add("Authorization", token);
		baseUrl = "https://localhost:8443" + "/api/userData";
		uri = new URI(baseUrl);
		request = new HttpEntity<>(httpHeaders);

		stringResponseEntity = this.restTemplate.postForEntity(uri, request, String.class);
		Assert.assertTrue(Objects.requireNonNull(stringResponseEntity.getBody()).contains("\"role\" : \"creepy\""));
	}

//	@Test
//	public void

//	@Test
//	public void rootData() {
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.add("Authorization", token);
//	}





	@Bean
	public RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

		SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
		                                                       .loadTrustMaterial(null, acceptingTrustStrategy)
		                                                       .build();

		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

		CloseableHttpClient httpClient = HttpClients.custom()
		                                            .setSSLSocketFactory(csf)
		                                            .build();

		HttpComponentsClientHttpRequestFactory requestFactory =	new HttpComponentsClientHttpRequestFactory();

		requestFactory.setHttpClient(httpClient);
		return new RestTemplate(requestFactory);
	}
}
