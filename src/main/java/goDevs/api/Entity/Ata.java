package goDevs.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goDevs.api.EntityPk.ContratoPk;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

@Entity
public class Ata {
    private String titulo,descricao,observacao;
    private Date data_Ata;


    @Column(length = 50 * 1024 * 1024) // 50 Mb
    private byte[] info;



    public boolean getInfo() {
        return info != null ? true:false;
    }

    public byte[] pegarInfo() {
        return info;
    }

    public void setInfo(byte[] info) {
        this.info = info;
    }

    public Ata() {
    }

    public Ata(String titulo, String descricao, String observacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.observacao = observacao;
        this.data_Ata = getData_Ata();

    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ata;

    @JsonIgnore
    @ManyToOne()
    private Contratante fk__;

    @JsonIgnore
    @ManyToOne()
    private Work fk;

    @ManyToOne()
    private Contratado fk_;

    @JsonIgnore
    public Contratante getFk__() {
        return fk__;
    }


    public Contratado getDev() {
        return fk_;
    }


    public void setFk_(Contratado fk_) {
        this.fk_ = fk_;
    }



    public void setFk(Work fk) {
        this.fk = fk;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getData_Ata() {
        return data_Ata;
    }

    public void setData_Ata(Date data_Ata) {
        this.data_Ata = data_Ata;
    }

    public Integer getId_ata() {
        return id_ata;
    }

    public void setId_ata(Integer id_ata) {
        this.id_ata = id_ata;
    }

    public void setFk__(Contratante fk__) {
        this.fk__ = fk__;
    }


}
