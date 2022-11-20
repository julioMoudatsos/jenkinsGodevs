package goDevs.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_work;
    private String titulo ;
    private Date data_inicio;
    private Date data_limite;
    private Double valor ;
    private String categoria;
    private boolean disponivel;
    private Boolean aprovado ;

    private boolean finalizado ;
    private String descricao ;

    @ManyToOne()
    private Contratante fk_;

    @ManyToOne()
    private Contratado fk__;

    @JsonIgnore
    @OneToMany(mappedBy = "fk")
    private List<Ata> atas = new ArrayList<>();



    public void setFk_(Contratante fk_) {
        this.fk_ = fk_;
    }

   public String pegarContratante(){
        return  fk_.getNome();
   }
    public Integer getId_work() {
        return id_work;
    }

    public void setId_work(Integer id_work) {
        this.id_work = id_work;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
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


    public Contratante getContratante() {
        return fk_;
    }

    public Contratante getFk_() {
        return fk_;
    }

    public Contratado getFk__() {
        return fk__;
    }

    public void setFk__(Contratado fk__) {
        this.fk__ = fk__;
    }
}
