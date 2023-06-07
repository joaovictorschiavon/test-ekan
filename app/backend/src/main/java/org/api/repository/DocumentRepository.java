package org.api.repository;

import org.api.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Documento, Long>{
    List<Documento> findByIdBeneficiario(Long idBeneficiario);
    <S extends Documento> S save(Documento documento);
    void delete(Documento documento);
}
