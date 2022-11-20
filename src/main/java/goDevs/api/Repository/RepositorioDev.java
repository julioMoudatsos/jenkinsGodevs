package goDevs.api.Repository;

import goDevs.api.Entity.Contratado;
import goDevs.api.Entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioDev extends JpaRepository<Contratado,Integer> {
    Contratado findByEmailAndSenha(String email, String senha);

}
