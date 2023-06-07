package org.api.controller;

import org.api.dto.*;
import org.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value= "api/clientes", produces= "application/json")
@RestController
public class ClientController {
    private ClientService clientService;
    private DocumentService documentService;

    @Autowired
    public ClientController(ClientService clientService, DocumentService documentService) {
        this.clientService = clientService;
        this.documentService = documentService;
    }

    // @ApiOperation(value = "Cria um cliente")
    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createClient(@RequestBody @Validated ClientRequestDTO clientRequestDTO) {
        try {
            final ClientResponseDTO clientResponseDTO = clientService.saveClient(clientRequestDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(clientResponseDTO);
        } catch ( Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // @ApiOperation(value = "Lista todos os clientes")
    @GetMapping
    public ResponseEntity<?> returnAllClients() {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientService.returnAllClients());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // @ApiOperation(value = "Retorna documentos de um cliente")
    @GetMapping(value = "/{idClient}")
    public ResponseEntity<?> getClient(@PathVariable Long idClient) throws Exception {
        // if (!idClient.equals(userDetail.getId())) {
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        // }

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(documentService.returnAllDocuments(idClient));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // @ApiOperation(value = "Atualiza dados de um cliente")
    @PutMapping(value = "/{idClient}", consumes = "application/json")
    public ResponseEntity<?> UpdateClient(
            @PathVariable Long idClient,
            @RequestBody @Validated ClientRequestDTO clientRequestDTO
            ) throws Exception {
        // if (!idClient.equals(userDetail.getId())) {
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        // }

        try {
            clientService.updateClient(idClient, clientRequestDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Beneficiário atualizado!");
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // @ApiOperation(value = "Deleta um cliente")
    @DeleteMapping(value = "/{idClient}")
    public ResponseEntity<?> deleteClient(@PathVariable Long idClient) throws Exception {
        // if (!idClient.equals(userDetail.getId())) {
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        // }

        try {
            clientService.deleteClient(idClient);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Cliente deletado com sucesso");
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}



