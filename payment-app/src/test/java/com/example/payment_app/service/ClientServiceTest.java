package com.example.payment_app.service;

import com.example.payment_app.dto.ClientDTO;
import com.example.payment_app.exception.ClientNotFoundException;
import com.example.payment_app.model.Client;
import com.example.payment_app.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }//лучше вместо этого добавить над классом @ExtendWith(MockitoExtension.class)

    @Test
    void getClientById_ClientExists_ReturnsClient() {
        Client client = new Client(1L, "John Doe", "+123456789", BigDecimal.valueOf(1000));
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Client foundClient = clientService.getClientById(1L);

        assertEquals(client, foundClient);
        verify(clientRepository, times(1)).findById(1L);//times(1) не надо. Просто verify подразумевает, что 1 раз исполняется
    }

    @Test
    void getClientById_ClientNotExists_ThrowsException() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ClientNotFoundException.class, () -> clientService.getClientById(1L));
        verify(clientRepository, times(1)).findById(1L);
    }

    // Другие тесты для метода createClient, updateClient и deleteClient
}
