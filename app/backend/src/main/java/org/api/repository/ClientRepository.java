package org.api.repository;

import org.api.model.Beneficiario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Beneficiario, Long>{
    List<Beneficiario> findAll();
    <S extends Beneficiario> S save(Beneficiario beneficiario);
    void delete(Beneficiario beneficiario);

}
