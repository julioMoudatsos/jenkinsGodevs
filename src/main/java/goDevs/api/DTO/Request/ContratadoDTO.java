package goDevs.api.DTO.Request;

public class ContratadoDTO {
    private String email;
    private String senha;

    public ContratadoDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
