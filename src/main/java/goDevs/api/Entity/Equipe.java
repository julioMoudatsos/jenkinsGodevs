package goDevs.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipe_id;

    private String nome;
    private String descricao;

    @JsonIgnore
    @ManyToOne()
    private Contratante fk__;


    @JsonIgnore
    @OneToMany(mappedBy = "fk__")
    private List<Work> prod = new ArrayList<>();

    public void setFk__(Contratante fk__) {
        this.fk__ = fk__;
    }

    public Integer getEquipe_id() {
        return equipe_id;
    }

    public void setEquipe_id(Integer equipe_id) {
        this.equipe_id = equipe_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
