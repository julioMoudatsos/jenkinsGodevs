package goDevs.api.Controllers;

import goDevs.api.Entity.*;
import goDevs.api.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/interesses")
public class InteressesController {

    @Autowired
    private RepositorioInteresses interessesRepositorio;

    @Autowired
    private RepositorioDev devRepositorio;

    @Autowired
    private RepositorioProjeto projetoRepositorio;

    @GetMapping
    public ResponseEntity getAvaliacao(){
        List<Interesses>  avaliacaos = interessesRepositorio.findAll();
        return  ResponseEntity.status(200).body(avaliacaos);
    }

    @PostMapping("/devId/{dev}/projetoId/{projeto}")
    public  ResponseEntity postAvaliacao(@RequestBody Interesses interesses, @PathVariable int dev,@PathVariable int projeto){
        Contratado contratadoInteressado = devRepositorio.findById(dev).get();
        Work workDev = projetoRepositorio.findById(projeto).get();
        interesses.setDev(contratadoInteressado);
        interesses.setProduct(workDev);
        interessesRepositorio.save(interesses);
        return  ResponseEntity.status(201).build();
    }




}


