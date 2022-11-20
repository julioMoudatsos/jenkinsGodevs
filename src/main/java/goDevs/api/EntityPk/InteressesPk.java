package goDevs.api.EntityPk;

import goDevs.api.Entity.Contratado;
import goDevs.api.Entity.Work;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class InteressesPk implements Serializable {
    private static final long serialVersionUID = 6243114494375482005L;

    @ManyToOne
    private Contratado fk_;

    @ManyToOne
    private Work fk__;


    public InteressesPk() {
    }

    public Contratado getDev() {
        return fk_;
    }

    public void setDev(Contratado contratado) {
        this.fk_ = contratado;
    }

    public Work getProjeto() {
        return fk__;
    }

    public void setProjeto(Work work) {
        this.fk__ = work;
    }
}
