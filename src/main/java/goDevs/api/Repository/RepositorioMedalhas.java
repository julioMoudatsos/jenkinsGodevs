package goDevs.api.Repository;

import goDevs.api.Entity.Interesses;
import goDevs.api.Entity.Medalhas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMedalhas extends JpaRepository<Medalhas,Integer> {
}
