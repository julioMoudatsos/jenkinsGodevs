package goDevs.api.Repository;

import goDevs.api.Entity.Avaliacao;
import goDevs.api.Entity.Interesses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioInteresses extends JpaRepository<Interesses,Integer> {
}
