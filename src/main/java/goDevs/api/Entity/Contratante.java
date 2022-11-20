package goDevs.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Contratante{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contratante")
    private Integer contratante;

    private String nome;

    private String email;

    @Column(name = "cpf_cnpj")
    private String cpfCNPJ;

    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "fk__")
    private List<Ata> atas = new ArrayList<>();


    @OneToMany(mappedBy = "fk_")
    private List<Work> prod = new ArrayList<>();

    public List<Work> Prod() {
        return prod;
    }

    @OneToMany(mappedBy = "fk__")
    private List<Equipe> equipe = new ArrayList<>();

    public List<Equipe> Equipe() {
        return equipe;
    }

    public Integer getContratante_id() {
        return contratante;
    }

    public void setContratante_id(Integer contratante_id) {
        this.contratante = contratante_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfCNPJ() {
        return cpfCNPJ;
    }

    public void setCpfCNPJ(String cpfCNPJ) {
        this.cpfCNPJ = cpfCNPJ;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
