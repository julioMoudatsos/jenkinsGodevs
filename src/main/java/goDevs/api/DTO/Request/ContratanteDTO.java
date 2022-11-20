package goDevs.api.DTO.Request;

public class ContratanteDTO {
    private String cpfCNPJ;
    private String senha;

    public ContratanteDTO(String cpfCNPJ, String senha) {
        this.cpfCNPJ = cpfCNPJ;
        this.senha = senha;
    }

    public String getCpfCNPJ() {
        return cpfCNPJ;
    }

    public String getSenha() {
        return senha;
    }
}
