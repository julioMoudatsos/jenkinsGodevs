package goDevs.api.DTO.documento;

public class DadosImportados {
    private String nome;
    private String funcao;
    private String equipe;
    private String atribuicoes;
    private String avaliacao;
    private String email;
    private String titulo;
    private String descricao;
    private String observacoes;
    private String data;

    public DadosImportados(String nome, String funcao, String equipe, String atribuicoes, String avaliacao, String email, String titulo, String descricao, String observacoes, String data) {
        this.nome = nome;
        this.funcao = funcao;
        this.equipe = equipe;
        this.atribuicoes = atribuicoes;
        this.avaliacao = avaliacao;
        this.email = email;
        this.titulo = titulo;
        this.descricao = descricao;
        this.observacoes = observacoes;
        this.data = data;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DadosImportados{" +
                "nome='" + nome + '\'' +
                ", funcao='" + funcao + '\'' +
                ", equipe='" + equipe + '\'' +
                ", atribuicoes='" + atribuicoes + '\'' +
                ", avaliacao='" + avaliacao + '\'' +
                ", email='" + email + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
