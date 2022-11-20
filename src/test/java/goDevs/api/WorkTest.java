package goDevs.api;

import goDevs.api.Controllers.WorkController;
import goDevs.api.Entity.Work;
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

@SpringBootTest(classes = {WorkController.class})
public class WorkTest {
    @MockBean
    private RepositorioContrantante contratanteRepositorio;

    @MockBean
    private RepositorioEquipe equipeRepositorio;

    @MockBean
    private RepositorioProjeto projetoRepositorio;

    @MockBean
    private RepositorioAta ataRepositorio;

    @Autowired
    WorkController w;
    @Test
    void getWorkVazio() {

        // aqui estamos 'ensinando' ao mock de AnimalEstimacaoRepository o que ele deve fazer caso alguém, neste teste, invoque seu "findAll()"
        // neste caso seu "findAll()" vai retornar uma lista vazia
        when(projetoRepositorio.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = w.getContratante();

        // verificando se o status da resposta é 204
        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void getWork() {
        Work c1 = mock(Work.class);
        Work c2 = mock(Work.class);
        List<Work> listMock = List.of(c1, c2);
        when(projetoRepositorio.findByDisponivelTrue()).thenReturn(listMock);

        ResponseEntity resposta = w.getContratante();

        assertEquals(200, resposta.getStatusCodeValue());
        assertNotNull(resposta.getBody());
        assertEquals(listMock, resposta.getBody());
    }
}
