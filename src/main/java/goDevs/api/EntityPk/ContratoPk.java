package goDevs.api.EntityPk;

import goDevs.api.Entity.Contratante;
import goDevs.api.Entity.Contratado;
import goDevs.api.Entity.Work;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ContratoPk implements Serializable {
    private static final long serialVersionUID = 6243114494375482005L;

    @ManyToOne
    private Contratado fk_;

    @ManyToOne
    private Work fk;

    @ManyToOne
    private Contratante fk__;


    public ContratoPk() {
    }

    public Contratado getDev() {
        return fk_;
    }

    public void setDev(Contratado fk_) {
        this.fk_ = fk_;
    }

    public Work getProjeto() {
        return fk;
    }

    public void setProjeto(Work fk) {
        this.fk = fk;
    }

    public Contratante getContratante() {
        return fk__;
    }

    public void setContratante(Contratante fk__) {
        this.fk__ = fk__;
    }
}
