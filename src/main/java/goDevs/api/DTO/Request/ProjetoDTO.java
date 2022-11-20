package goDevs.api.DTO.Request;

import java.util.Date;

public class ProjetoDTO {
    private String titulo ;
    private String descricao;
    private Date data_limite;
    private Date data_inicio;
    private Double valor ;
    private String categoria;

    private String senha ;
    private boolean disponivel;
    private boolean finalizado ;

    public ProjetoDTO(String nome_vaga, String descricao, Date data_limite, Date data_inicio, Double valor, String categoria, String senha, boolean disponivel, boolean finalizado) {
        this.titulo = nome_vaga;
        this.descricao = descricao;
        this.data_limite = data_limite;
        this.data_inicio = data_inicio;
        this.valor = valor;
        this.categoria = categoria;

        this.senha = senha;
        this.disponivel = disponivel;
        this.finalizado = finalizado;
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



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
