package goDevs.api.Controllers;

import goDevs.api.Entity.Work;
import goDevs.api.FilaObj;
import goDevs.api.Repository.RepositorioProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/works")
public class WorkController {

    @Autowired
    private RepositorioProjeto repository;

    @GetMapping
    public ResponseEntity getContratante(){
        List<Work> works = repository.findByDisponivelTrue();
        if(works.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        FilaObj<Work> fila = new FilaObj<Work>(20);
        for (Work w: works){
            fila.insert(w);
        }
        return ResponseEntity.status(200).body(works);
    }

    @GetMapping("/{id}")
    public ResponseEntity getWorkById(@PathVariable int id) {
        Optional<Work> work = repository.findById(id);
        if (work.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(work);
    }

    @GetMapping("/filtrado/{filtro}")
    public ResponseEntity<List<Work>> getWorksFiltered(@PathVariable String filtro) {
        List<Work> w = repository.findWorkFiltered(filtro);

        return ResponseEntity.status(200).body(w);
    }

    @GetMapping("/cont/{id}")
    public ResponseEntity<List<Work>> getWorksByIdContratante(@PathVariable Integer id) {
        List<Work> w = repository.findAll();
        List<Work> works = new ArrayList<>();

        for(Work w1: w){
            if(Objects.equals(w1.getContratante().getContratante_id(), id) && Objects.equals(w1.isDisponivel(), true)){
                works.add(w1);
            }
        }
        if (w.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(works);
    }

    @GetMapping("/hist/cont/{id}")
    public ResponseEntity<List<Work>> getWorksHistByIdContratante(@PathVariable Integer id) {
        List<Work> w = repository.findAll();
        List<Work> works = new ArrayList<>();

        for(Work w1: w){
            if(Objects.equals(w1.getContratante().getContratante_id(), id)){
                works.add(w1);
            }
        }
        if (w.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(works);
    }

    @GetMapping("/relatorio/{id}")
    public ResponseEntity gravarCsv(@PathVariable Integer id) throws IOException {
        String csv = "";
        List<Work> w = repository.findAll();
        List<Work> works = new ArrayList<>();

        for(Work w1: w){
            if(w1.getFk__() != null) {
                if(Objects.equals(w1.getFk__().getId_contratado(), id)){
                    works.add(w1);
                }
            }
        }

        for (Work w1 : works) {
            csv += String.format("%d,%s,%s,%s,%.2f,%s,%s,%s,%s,%s\r\n", w1.getId_work(), w1.getTitulo(), w1.getDescricao(), w1.getCategoria(),
                    w1.getValor(), w1.getData_inicio(), w1.getData_limite(), w1.getContratante(), w1.getAprovado() ? "Aprovado" : "Reprovado");
        }

        return ResponseEntity.status(200)
                .header("content-disposition", "filename=\"relatorio-works.csv\"")
                .header("content-type", "text/csv")
                .body(csv);
    }

    @GetMapping("/dev/{id}")
    public ResponseEntity<List<Work>> getWorksByIdDev(@PathVariable Integer id) {
        List<Work> w = repository.findAll();
        List<Work> works = new ArrayList<>();

        for(Work w1: w){
            if(w1.getFk__() != null) {
                if(Objects.equals(w1.getFk__().getId_contratado(), id)){
                    works.add(w1);
                }
            }
        }
        if (w.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(works);
    }
}
