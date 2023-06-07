package org.api.service;

import org.api.dto.ClientRequestDTO;
import org.api.dto.ClientResponseDTO;


import java.util.List;

public interface ClientService {
    ClientResponseDTO saveClient(ClientRequestDTO clientRequestDTO) throws Exception;

    List<ClientResponseDTO> returnAllClients() throws Exception;

    void updateClient(Long id, ClientRequestDTO clientRequestDTO) throws Exception;

    void deleteClient(Long id) throws Exception;
}
