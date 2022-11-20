package goDevs.api.DTO.documento;

public class Ata {
    private String titulo;
    private String descricao;
    private String observacoes;
    private String data;

    public Ata(String titulo, String descricao, String observacoes, String data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.observacoes = observacoes;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Ata{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
