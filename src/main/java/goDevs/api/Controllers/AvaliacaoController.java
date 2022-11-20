package goDevs.api.Controllers;

import goDevs.api.Entity.Avaliacao;
import goDevs.api.Entity.Contratante;
import goDevs.api.Entity.Contratado;
import goDevs.api.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private RepositorioAvaliacao avaliacaoRepositorio;

    @Autowired
    private RepositorioDev devRepositorio;

    @Autowired
    private RepositorioContrantante contratanteRepositorio;


    @GetMapping
    public ResponseEntity getAvaliacao(){
        List<Avaliacao>  avaliacaos = avaliacaoRepositorio.findAll();
        return  ResponseEntity.status(200).body(avaliacaos);
    }

    @PostMapping("/devId/{dev}/contratanteId/{contratante}")
    public  ResponseEntity postAvaliacao(@RequestBody Avaliacao avaliacao, @PathVariable int dev,@PathVariable int contratante){
        Contratado contratadoNota = devRepositorio.findById(dev).get();
        Contratante contratanteNota = contratanteRepositorio.findById(contratante).get();
        avaliacao.setContrante(contratanteNota);
        avaliacao.setDev(contratadoNota);
        avaliacaoRepositorio.save(avaliacao);
        return  ResponseEntity.status(201).build();
    }




}


