package org.api.service;

import org.api.dto.DocumentResponseDTO;
import org.api.model.Documento;
import org.api.repository.DocumentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentServiceImpl implements DocumentService{
    private DocumentRepository documentRepository;
    
    @Override
    public List<DocumentResponseDTO> returnAllDocuments(Long id) throws Exception {
        List<Documento> documents = this.documentRepository.findByIdBeneficiario(id);
        return documents.stream().map(DocumentResponseDTO::convert).collect(Collectors.toList());
    }
}
