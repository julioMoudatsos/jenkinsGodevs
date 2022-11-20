package goDevs.api.DTO.Request;

import java.util.Date;

public class DevDTO {
    private String nome_vaga ;
    private String descricao;
    private Date data_limite;
    private Date data_inicio;
    private Double valor ;
    private String categoria;

    private String foto ;
    private String senha ;
    private int disponivel;
    private int finalizado ;

    public DevDTO(String nome_vaga, String descricao, Date data_limite, Date data_inicio, Double valor, String categoria, String foto, String senha, int disponivel, int finalizado) {
        this.nome_vaga = nome_vaga;
        this.descricao = descricao;
        this.data_limite = data_limite;
        this.data_inicio = data_inicio;
        this.valor = valor;
        this.categoria = categoria;
        this.foto = foto;
        this.senha = senha;
        this.disponivel = disponivel;
        this.finalizado = finalizado;
    }

    public String getNome_vaga() {
        return nome_vaga;
    }

    public void setNome_vaga(String nome_vaga) {
        this.nome_vaga = nome_vaga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_limite() {
        return data_limite;
    }

    public void setData_limite(Date data_limite) {
        this.data_limite = data_limite;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }

    public int getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }
}
