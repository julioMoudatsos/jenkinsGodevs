package goDevs.api.Repository;

import goDevs.api.Entity.Contratante;
import goDevs.api.Entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioProjeto extends JpaRepository<Work,Integer> {
    @Query("SELECT w FROM Work w where w.categoria LIKE %?1% and w.disponivel = true")
    List<Work> findWorkFiltered(String filter);

    List<Work> findByDisponivelTrue();

}
