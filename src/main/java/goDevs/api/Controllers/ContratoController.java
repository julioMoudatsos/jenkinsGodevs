package goDevs.api.Controllers;

import goDevs.api.Entity.Contratante;
import goDevs.api.Entity.Contrato;
import goDevs.api.Entity.Contratado;
import goDevs.api.Entity.Work;
import goDevs.api.Repository.RepositorioContrantante;
import goDevs.api.Repository.RepositorioContrato;
import goDevs.api.Repository.RepositorioDev;
import goDevs.api.Repository.RepositorioProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/contrato")
public class ContratoController {

    @Autowired
    private RepositorioDev devRepositorio;

    @Autowired
    private RepositorioProjeto projetoRepositorio;

    @PostMapping("/dev/{devid}/projeto/{projetoid}")
    public  ResponseEntity postContrato(@PathVariable int devid,
                                        @PathVariable int projetoid){

       Work workContrato = projetoRepositorio.findById(projetoid).get();
       Contratado c = devRepositorio.findById(devid).get();
       workContrato.setFk__(c);
       workContrato.setDisponivel(false);
       projetoRepositorio.save(workContrato);
       return  ResponseEntity.status(201).build();
   }
    @PostMapping("/projeto/finalizado/{projetoid}")
    public ResponseEntity postFinalizado(@PathVariable int projetoid) {
        Work workContrato = projetoRepositorio.findById(projetoid).get();
        workContrato.setFinalizado(true);
        projetoRepositorio.save(workContrato);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/projeto/aprovado/{projetoid}")
    public ResponseEntity postAprovado(@PathVariable int projetoid) {
        Work workContrato = projetoRepositorio.findById(projetoid).get();
        workContrato.setAprovado(true);
        projetoRepositorio.save(workContrato);
        return ResponseEntity.status(201).build();
    }


}


