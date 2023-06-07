package org.api.dto;

import java.util.Date;
import org.api.model.Documento;

public class DocumentResponseDTO {
    private Long id;
    private String tipoDocumento;
    private String descricao;
    private Date dataInclusao;
    private Date dataAtualizacao;

    public static DocumentResponseDTO convert(Documento documento) {
        var documentResponseDTO = new DocumentResponseDTO();

        documentResponseDTO.setId(documento.getId());
        documentResponseDTO.setTipoDocumento(documento.getTipoDocumento());
        documentResponseDTO.setDescricao(documento.getDescricao());
        documentResponseDTO.setDataInclusao(documento.getDataInclusao());
        documentResponseDTO.setDataAtualizacao(documento.getDataAtualizacao());

        return documentResponseDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
