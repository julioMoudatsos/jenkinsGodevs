package goDevs.api;

import goDevs.api.Controllers.ContratanteController;
import goDevs.api.Entity.Contratado;
import goDevs.api.Entity.Contratante;
import goDevs.api.Repository.RepositorioAta;
import goDevs.api.Repository.RepositorioContrantante;
import goDevs.api.Repository.RepositorioEquipe;
import goDevs.api.Repository.RepositorioProjeto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ContratanteController.class})
public class ContratanteTest {
    @MockBean
    private RepositorioContrantante contratanteRepositorio;

    @MockBean
    private RepositorioEquipe equipeRepositorio;

    @MockBean
    private RepositorioProjeto projetoRepositorio;

    @MockBean
    private RepositorioAta ataRepositorio;

    @Autowired
    private ContratanteController c;

    @Test
    void getContratanteVazio() {

        // aqui estamos 'ensinando' ao mock de AnimalEstimacaoRepository o que ele deve fazer caso alguém, neste teste, invoque seu "findAll()"
        // neste caso seu "findAll()" vai retornar uma lista vazia
        when(contratanteRepositorio.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = c.getContratante();

        // verificando se o status da resposta é 204
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void getContratante() {
        Contratante c1 = mock(Contratante.class);
        Contratante c2 = mock(Contratante.class);
        List<Contratante> listMock = List.of(c1, c2);
        when(contratanteRepositorio.findAll()).thenReturn(listMock);

        ResponseEntity resposta = c.getContratante();

        assertEquals(200, resposta.getStatusCodeValue());
        assertNotNull(resposta.getBody());
        assertEquals(listMock, resposta.getBody());
    }
}
