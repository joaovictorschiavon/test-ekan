package org.api.service;

import org.api.model.Beneficiario;
import org.api.dto.ClientRequestDTO;
import org.api.dto.ClientResponseDTO;
import org.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;


@Service
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponseDTO saveClient(ClientRequestDTO clientRequestDTO) throws Exception {
        var client = new Beneficiario();

        this.clientRepository.save(client);
        return ClientResponseDTO.convert(client);
    }

    @Override
    public List<ClientResponseDTO> returnAllClients() throws Exception {
        var clients = this.clientRepository.findAll();
        return clients.stream().map(ClientResponseDTO::convert).collect(Collectors.toList());
    }

    @Override
    public void updateClient(Long id, ClientRequestDTO clientRequestDTO) throws Exception {
        var client = clientRepository.findById(id).orElseThrow(() -> new Exception("Beneficiário não encontrado!"));
        client.setNome(clientRequestDTO.getNome());
        client.setTelefone(clientRequestDTO.getTelefone());
        client.setDataNascimento(clientRequestDTO.getDataNascimento());
        client.setDataAtualizacao(new Date());

        this.clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) throws Exception {
        var client = this.clientRepository.findById(id).orElseThrow(() -> new Exception("Beneficiário não encontrado"));
        
        this.clientRepository.delete(client);
    }
}
