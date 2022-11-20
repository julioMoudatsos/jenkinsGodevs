package goDevs.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goDevs.api.EntityPk.InteressesPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Interesses {

    @EmbeddedId
    private InteressesPk id = new InteressesPk();
    private int situacao;

    public Interesses() {
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Work getProjeto(){
        return  id.getProjeto();
    }
    public  void  setProduct(Work work){
        id.setProjeto(work);
    }

    @JsonIgnore
    public Contratado getDev(){
        return  id.getDev();
    }
    public  void  setDev(Contratado contratado){
        id.setDev(contratado);
    }



}
