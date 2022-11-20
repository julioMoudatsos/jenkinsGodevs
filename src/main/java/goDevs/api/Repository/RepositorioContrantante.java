package goDevs.api.Repository;

import goDevs.api.DTO.Response.ContratadoResponse;
import goDevs.api.Entity.Contratante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioContrantante extends JpaRepository<Contratante,Integer> {
    Contratante findByCpfCNPJAndSenha(String CpfCNPJ, String senha);
}
