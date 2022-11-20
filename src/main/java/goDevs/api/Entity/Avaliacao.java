package goDevs.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goDevs.api.EntityPk.AvaliacaoPk;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Avaliacao {
    @EmbeddedId
    private AvaliacaoPk id = new AvaliacaoPk();
    @Column(name = "valor")
    private Double value;



    public Avaliacao() {
    }



    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @JsonIgnore
    public Contratado getDev(){
        return  id.getDev();
    }

    public void setDev(Contratado mv) {
        id.setDev(mv);
    }

    public void setContrante(Contratante mv) {
        id.setContratante(mv);
    }
    @JsonIgnore
    public Contratante getContrante()  {
       return id.getContratante();
    }

}
