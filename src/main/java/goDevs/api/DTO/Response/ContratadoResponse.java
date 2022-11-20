package goDevs.api.DTO.Response;


import java.util.Date;

public class ContratadoResponse {
    private Integer codigo;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Date dataNasc;
    private Integer nivelCon;

    public ContratadoResponse(Integer codigo, String nome, String email, String cpf, String telefone, Date dataNasc, Integer nivelCon) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.nivelCon = nivelCon;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public Integer getNivelCon() {
        return nivelCon;
    }
}
