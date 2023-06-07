package org.api.service;

import org.api.dto.DocumentResponseDTO;

import java.util.List;

public interface DocumentService {
    List<DocumentResponseDTO> returnAllDocuments(Long id) throws Exception;
}
