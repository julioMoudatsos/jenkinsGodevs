package goDevs.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goDevs.api.EntityPk.ContratoPk;

import javax.persistence.*;

@Entity
public class Contrato {

    @EmbeddedId
    private ContratoPk id = new ContratoPk();


    public Contrato() {
    }

    public Work getProjeto(){
        return  id.getProjeto();
    }
    public  void  setProjeto(Work work){
        id.setProjeto(work);
    }

    public  Contratante getContratante(){
        return  id.getContratante();
    }
    public  void  setContratante(Contratante contratante){
        id.setContratante(contratante);
    }

    @JsonIgnore
    public Contratado getDev(){
        return  id.getDev();
    }
    public  void  setDev(Contratado contratado){
        id.setDev(contratado);
    }

}
