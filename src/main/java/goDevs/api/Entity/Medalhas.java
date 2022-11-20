package goDevs.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Medalhas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="medalhas_id")
    private Integer id;

    private String nome;

    @JsonIgnore
    @ManyToOne()
    private Contratado fk_;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contratado getFk_() {
        return fk_;
    }

    public void setFk_(Contratado fk_) {
        this.fk_ = fk_;
    }
}
