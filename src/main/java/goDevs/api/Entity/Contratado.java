package goDevs.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Contratado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_contratado;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Date data_nasc;
    private String quem_sou;
    private String experiencias;
    private String senha;
    private String linkedin;
    private Integer nivel_con;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_")
    private List<Ata> atas = new ArrayList<>();

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId_contratado() {
        return id_contratado;
    }

    public void setId_contratado(Integer id_contratado) {
        this.id_contratado = id_contratado;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getQuem_sou() {
        return quem_sou;
    }

    public void setQuem_sou(String quem_sou) {
        this.quem_sou = quem_sou;
    }

    public String getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(String experiencias) {
        this.experiencias = experiencias;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public Integer getNivel_con() {
        return nivel_con;
    }

    public void setNivel_con(Integer nivel_con) {
        this.nivel_con = nivel_con;
    }


}
