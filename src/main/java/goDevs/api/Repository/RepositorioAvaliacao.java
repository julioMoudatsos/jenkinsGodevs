package goDevs.api.Repository;

import goDevs.api.Entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAvaliacao extends JpaRepository<Avaliacao,Integer> {
}
