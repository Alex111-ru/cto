package com.example.payment_app.service;


import com.example.payment_app.dto.ClientDTO;
import com.example.payment_app.exception.ClientNotFoundException;
import com.example.payment_app.model.Client;
import com.example.payment_app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }

    public Client createClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setBalance(clientDTO.getBalance());
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, ClientDTO clientDTO) {
        Client client = getClientById(id);
        client.setName(clientDTO.getName());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setBalance(clientDTO.getBalance());
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }
}
