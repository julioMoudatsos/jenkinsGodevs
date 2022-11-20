package goDevs.api.Repository;

import goDevs.api.DTO.Request.AtaDTO;
import goDevs.api.Entity.Ata;
import goDevs.api.Entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RepositorioAta extends JpaRepository<Ata,Integer> {



    @Query("update Ata a set a.info =?2 where a.id_ata = ?1")
    @Transactional
    @Modifying
    int atualizarArquivoTxt(int codigo, byte[] novoTxt);

    @Query("select a.info from Ata a where a.id_ata = ?1")
    public byte[] getArquivoTxt(int codigo);


    @Query("select a from Ata a where fk_id_work = ?1")
    public List<Ata> pegarAta(int work);

    @Query("select a from Ata a where fk__id_contratado = ?1")
    public List<Ata> pegarDevAta(int dev);


}
