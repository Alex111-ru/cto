package com.example.payment_app;

import com.example.payment_app.dto.ClientDTO;
import com.example.payment_app.model.Client;
import com.example.payment_app.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;//а вот в тестах автовайрить через поля нормальная практика

	@Autowired
	private ClientRepository clientRepository;//неиспользуемые зависимости должны быть удалены

	@Test
	void createClientTest() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setName("Jane Doe");
		clientDTO.setPhoneNumber("+987654321");
		clientDTO.setBalance(BigDecimal.valueOf(500));

		ResponseEntity<Client> response = restTemplate.postForEntity("http://localhost:" + port + "/clients", clientDTO, Client.class);

		assertEquals(201, response.getStatusCodeValue());
		assertNotNull(response.getBody());
		assertEquals("Jane Doe", response.getBody().getName());
	}

	// Другие интеграционные тесты для методов контроллера
}
