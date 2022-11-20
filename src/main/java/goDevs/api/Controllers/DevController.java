package goDevs.api.Controllers;

import goDevs.api.DTO.Request.AtaDTO;
import goDevs.api.DTO.Request.ContratadoDTO;
import goDevs.api.Entity.*;
import goDevs.api.PilhaObj;
import goDevs.api.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dev")
public class DevController {

    @Autowired
    private RepositorioDev devRepositorio;
    @Autowired
    private RepositorioMedalhas medalhasRepositorio;

    @Autowired
    private RepositorioAta ataRepositorio;

    @Autowired
    private RepositorioContrantante contratanteRepositorio;

    @Autowired
    private RepositorioProjeto projetoRepositorio;

    PilhaObj<Ata> pilhaAta = new PilhaObj<>(20);

    @GetMapping
    public ResponseEntity getContratantes(){
        List<Contratado> contratados = devRepositorio.findAll();
        if(contratados.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.status(200).body(contratados);
    }

    @GetMapping("/{id}")
    public ResponseEntity getContratante(@PathVariable  int id){
          Optional<Contratado> dev = devRepositorio.findById(id);
        if(dev.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.status(200).body(dev.get());
    }

    @PostMapping("/login-contratado")
    public ResponseEntity<Contratado> loginContratante(@RequestBody ContratadoDTO a) {
        Contratado login = devRepositorio.findByEmailAndSenha(a.getEmail(), a.getSenha());
        if (login == null) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(login);
    }

    @PostMapping
    public ResponseEntity postDev(
            @RequestBody Contratado novoContratado) {
        devRepositorio.save(novoContratado);
        return status(201).build();
    }


    @PostMapping("/medalha/{medalhaId}/dev/{devId}")
    public  ResponseEntity ganharMedalha(@PathVariable int medalhaId,@PathVariable int devId){
        Contratado vencedor = devRepositorio.findById(devId).get();
        Medalhas medalha = medalhasRepositorio.findById(medalhaId).get();
        medalha.setFk_(vencedor);
        medalhasRepositorio.save(medalha);
        return status(201).build();
    }

    @GetMapping("/medalhas")
    public  ResponseEntity ganharMedalha(){
      List<Medalhas> medalhas =   medalhasRepositorio.findAll();
        return status(200).body(medalhas);

    }
    @GetMapping("/atas/work/{work}")
    public ResponseEntity getContratanteProjetos(@PathVariable int work){

        List<Ata> works = ataRepositorio.pegarAta(work);
        return  ResponseEntity.status(200).body(works);
    }

    @PostMapping("/devid/{devid}/contratante/{contratanteid}/projeto/{projetoid}")
    public  ResponseEntity postAta(@PathVariable int devid,
                                        @RequestBody Ata ata,
                                        @PathVariable int contratanteid,
                                        @PathVariable int projetoid){

        Contratado contratadoContrato = devRepositorio.findById(devid).get();
        Contratante contratanteContrato = contratanteRepositorio.findById(contratanteid).get();
        Work workContrato = projetoRepositorio.findById(projetoid).get();

        ata.setFk__(contratanteContrato);
        ata.setFk_(contratadoContrato);
        ata.setFk(workContrato);
        ataRepositorio.save(ata);
        return  ResponseEntity.status(201).build();
    }

    @GetMapping("/atadev/{id}")
    public  ResponseEntity pegarDevAtas(@PathVariable int id){
        List<Ata> atas =   ataRepositorio.pegarDevAta(id);
        return atas.size() > 0?status(200).body(atas):status(404).build();

    }
    @GetMapping("/atadevup/{id}")
    public  ResponseEntity getUpAtasDev(@PathVariable int id){
        byte[] atas =   ataRepositorio.getArquivoTxt(id);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.status(200)
                .header(String.valueOf(headers))
                .header("content-disposition", "filename=\"informativo.text\"")
                .header("content-type", "text/txt")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(atas);
    }

    @DeleteMapping("/atadev/delete/{id}")
    public ResponseEntity deleteAta(@PathVariable int id){
        Ata a = ataRepositorio.getById(id);
        pilhaAta.push(a);
        ataRepositorio.delete(a);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/atadev/undoAta")
    public ResponseEntity undoAta(){
        Ata a = pilhaAta.peek();
        ataRepositorio.save(a);
        pilhaAta.pop();
        return ResponseEntity.ok().build();
    }
}
