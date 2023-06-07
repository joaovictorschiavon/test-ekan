package org.api.dto;

import java.util.Date;
import org.api.model.Beneficiario;

public class ClientResponseDTO {
    private Long id;
    private String nome;
    private String telefone;
    private Date dataNascimento;
    private Date dataInclusao;
    private Date dataAtualizacao;

    public static ClientResponseDTO convert(Beneficiario client) {
        var clientResponseDTO = new ClientResponseDTO();

        clientResponseDTO.setId(client.getId());
        clientResponseDTO.setNome(client.getNome());
        clientResponseDTO.setTelefone(client.getTelefone());
        clientResponseDTO.setDataNascimento(client.getDataNascimento());
        clientResponseDTO.setDataInclusao(client.getDataInclusao());
        clientResponseDTO.setDataAtualizacao(client.getDataAtualizacao());

        return clientResponseDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
