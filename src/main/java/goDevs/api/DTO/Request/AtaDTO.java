package goDevs.api.DTO.Request;

import java.util.Date;

public class AtaDTO {
    private String titulo,descricao,observacao;
  private Date data_Ata;

    public AtaDTO(String titulo, String descricao, String observacao, Date data_Ata) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.observacao = observacao;
        this.data_Ata = data_Ata;
    }

    public Date getData_Ata() {
        return data_Ata;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getObservacao() {
        return observacao;
    }


}
