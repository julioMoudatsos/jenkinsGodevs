package goDevs.api;

import goDevs.api.Controllers.DevController;
import goDevs.api.Entity.Contratado;
import goDevs.api.Repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {DevController.class})
public class DevTest {

    @Autowired
    DevController d;
    @MockBean
    RepositorioDev r;
    @MockBean
    RepositorioMedalhas medalhasRepositorio;
    @MockBean
    RepositorioAta ataRepositorio;
    @MockBean
    RepositorioContrantante contratanteRepositorio;
    @MockBean
    RepositorioProjeto projetoRepositorio;

    @Test
    @DisplayName("Sem devs deveria retornar 204 SEM corpo")
    void getDevsVazio() {

        // aqui estamos 'ensinando' ao mock de AnimalEstimacaoRepository o que ele deve fazer caso alguém, neste teste, invoque seu "findAll()"
        // neste caso seu "findAll()" vai retornar uma lista vazia
        when(r.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = d.getContratantes();

        // verificando se o status da resposta é 204
        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    @DisplayName("Com devs deveria retornar 200 com corpo")
    void getDevs() {
        Contratado c1 = mock(Contratado.class);
        Contratado c2 = mock(Contratado.class);
        List<Contratado> listMock = List.of(c1, c2);
        when(r.findAll()).thenReturn(listMock);

        ResponseEntity resposta = d.getContratantes();

        assertEquals(400, resposta.getStatusCodeValue());
        assertNotNull(resposta.getBody());
        assertEquals(listMock, resposta.getBody());
    }
}
