package goDevs.api.DTO.documento;

public class DadosContratado {
    private String nome;
    private String funcao;
    private String equipe;
    private String atribuicoes;
    private String avaliacao;
    private String email;

    public DadosContratado(String nome, String funcao, String equipe, String atribuicoes, String avaliacao, String email) {
        this.nome = nome;
        this.funcao = funcao;
        this.equipe = equipe;
        this.atribuicoes = atribuicoes;
        this.avaliacao = avaliacao;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicoes(String atribuicoes) {
        this.atribuicoes = atribuicoes;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DadosContratado{" +
                "nome='" + nome + '\'' +
                ", funcao='" + funcao + '\'' +
                ", equipe='" + equipe + '\'' +
                ", atribuicoes='" + atribuicoes + '\'' +
                ", avaliacao='" + avaliacao + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
