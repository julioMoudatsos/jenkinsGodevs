package goDevs.api.Controllers;

import goDevs.api.DTO.Request.ContratanteDTO;
import goDevs.api.DTO.Request.EquipeDTO;
import goDevs.api.DTO.Request.ProjetoDTO;
import goDevs.api.Entity.Ata;
import goDevs.api.Entity.Contratante;
import goDevs.api.Entity.Equipe;
import goDevs.api.Entity.Work;
import goDevs.api.Repository.RepositorioAta;
import goDevs.api.Repository.RepositorioContrantante;
import goDevs.api.Repository.RepositorioEquipe;
import goDevs.api.Repository.RepositorioProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/contratante")
public class ContratanteController {

    @Autowired
    private RepositorioContrantante contratanteRepositorio;

    @Autowired
    private RepositorioEquipe equipeRepositorio;

    @Autowired
    private RepositorioProjeto projetoRepositorio;

    @Autowired
    private RepositorioAta ataRepositorio;

    @GetMapping
    public ResponseEntity getContratante(){
        List<Contratante>  contratantes = contratanteRepositorio.findAll();
        return  ResponseEntity.status(200).body(contratantes);
    }
    @GetMapping("{id}")
    public ResponseEntity getContratante(@PathVariable Integer id){
        Contratante  contratante = contratanteRepositorio.findById(id).get();
        return  ResponseEntity.status(200).body(contratante);
    }

    @GetMapping("/ata")
    public ResponseEntity getAta(){
        List<Ata>  atas = ataRepositorio.findAll();
        return  ResponseEntity.status(200).body(atas);
    }

    @GetMapping("/equipes/{id}")
    public ResponseEntity getContratanteEquipe(@PathVariable Integer id){
         Optional<Contratante> contratantes = contratanteRepositorio.findById(id);
         List<Equipe> equipes = contratantes.get().Equipe();
        return  ResponseEntity.status(200).body(equipes);
    }

    @GetMapping("/projetos/{id}")
    public ResponseEntity getContratanteProjetos(@PathVariable Integer id){
        Optional<Contratante> contratantes = contratanteRepositorio.findById(id);
        List<Work> works = contratantes.get().Prod();
        return  ResponseEntity.status(200).body(works);
    }

    @PostMapping("/login-contratante")
    public ResponseEntity<Contratante> loginContratante(@RequestBody ContratanteDTO a) {
        Contratante login = contratanteRepositorio.findByCpfCNPJAndSenha(a.getCpfCNPJ(), a.getSenha());
        if (login == null) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(login);
    }

    @PostMapping
    public ResponseEntity postContratante(
            @RequestBody Contratante novoContratante) {
        contratanteRepositorio.save(novoContratante);
        return status(201).build();
    }

    @PostMapping("/equipe/{id}")
    public  ResponseEntity postEquipe(@PathVariable Integer id, @RequestBody EquipeDTO dto){
         Equipe novaEquipe = new Equipe();
         Contratante contratante = contratanteRepositorio.findById(id).get();
         novaEquipe.setNome(dto.getNome());
         novaEquipe.setDescricao(dto.getDescricao());
         novaEquipe.setFk__(contratante);
        equipeRepositorio.save(novaEquipe);
        return status(201).build();
    }

    @PostMapping("/projeto/{id}")
    public  ResponseEntity postWork(@PathVariable Integer id, @RequestBody ProjetoDTO dto){
        Work novoWork = new Work();
        Contratante contratante = contratanteRepositorio.findById(id).get();

        novoWork.setFk_(contratante);
        novoWork.setTitulo(dto.getTitulo());
        novoWork.setCategoria(dto.getCategoria());
        novoWork.setData_inicio(dto.getData_inicio());
        novoWork.setData_limite(dto.getData_limite());
        novoWork.setDescricao(dto.getDescricao());
        novoWork.setValor(dto.getValor());
        novoWork.setDisponivel(true);
        novoWork.setFinalizado(false);
        novoWork.setAprovado(false);

        projetoRepositorio.save(novoWork);
        return status(201).build();
    }




    static List<Ata> listaLida = new ArrayList<>();
    static String txt ="";
    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        // try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        // try-catch para gravar o registro e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: " + erro);
        }
    }
    public static String gravaArquivoTxt(List<Ata> lista, String nomeArq) {
        int contaRegistroCorpo = 0;

        // Monta o registro de header
        String header = "00Descricao de tarefas";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";
        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de corpo
        String corpo0="", corpo1="";
        for (Ata d : lista) {
            corpo0 = "02";
            corpo0 += String.format("%-30.50s", d.getDev().getNome());
            corpo0 += String.format("%-70.100s", d.getDev().getEmail());
            gravaRegistro(corpo0, nomeArq);

            corpo1 = "03";
            corpo1 += String.format("%-30.30s", d.getTitulo());
            corpo1 += String.format("%-70.100s", d.getDescricao());
            corpo1 += String.format("%-50.50s", d.getObservacao());
            corpo1 += String.format("%-19.19s", d.getData_Ata());
            contaRegistroCorpo++;
            gravaRegistro(corpo1, nomeArq);


        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d", contaRegistroCorpo);
        gravaRegistro(trailer, nomeArq);

        String txt = header + " " + corpo0 + " " +corpo1 + trailer;
        return txt;
    }
    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        int contaRegistroCorpoLido = 0;
        int qtdRegistroCorpoGravado = 0;
        String registro, tipoRegistro;
        String nome, descricao, obeservacao;


        int contaRegCorpoLido = 0;
        int qtdRegCorpoGravado = 0;

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        try {

            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0,2);
                if (tipoRegistro.equals("00")) {
                    txt+= "É um registro de header \n";
                    txt+= "Tipo de arquivo: "
                            + registro.substring(2, 22) +" \n";

                    txt+=  "Data e hora da gravação: "
                            + registro.substring(22, 41) +" \n";
                     txt+="Versão do documento: "
                             + registro.substring(41, 43) +" \n";
                }
                else if (tipoRegistro.equals("01")) {
                    txt+= "É um registro de trailler" +" \n";

                    qtdRegistroCorpoGravado =
                            Integer.parseInt(registro.substring(2, 7));
                    if (contaRegCorpoLido == qtdRegCorpoGravado) {

                        System.out.println("Quantidade de registros lidos é compatível " +
                                "com a quantidade de registros gravados");
                    }
                    else {
                        System.out.println("Quantidade de registros lidos não é compatível " +
                                "com a quantidade de registros gravados");
                    }
                }
                else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de corpo");
                    nome = registro.substring(2, 52).trim();
                    descricao = registro.substring(52, 82).trim();
                    obeservacao = registro.substring(82, 112).trim();

                    txt+="É um registro de corpo \n" ;
                    txt += "nome: " +  registro.substring(2, 52).trim() + "\n";
                    txt += "descricao: " + registro.substring(52, 82).trim() + "\n";
                    txt += " obeservacao: " + registro.substring(82, 112).trim() + "\n";

                    contaRegistroCorpoLido++;
                     LocalDateTime data;

                    Ata a = new Ata(nome,descricao,obeservacao);
                    // No projeto de PI, poderia fazer:
                    // repository.save(a);

                    // No nosso caso, vamos adicionar o objeto a na listaLida:
                    listaLida.add(a);
                }
                else {
                    System.out.println("Tipo de registro inválido!");
                }

                // Lê o próximo registro
                registro = entrada.readLine();
            }

            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo: " + erro);
        }

        // No Projeto de PI, pode-se fazer:
        // repository.saveAll(listaLida);

        // Vamos exibir a listaLida


    }




    @GetMapping("/relatorios/{id}")
    public ResponseEntity gravarCsv(@PathVariable Integer id) throws IOException {
        List<Ata> works = ataRepositorio.pegarAta(id);
        String relatorio = "-";
        for (Ata ata : works) {
            System.out.println("girou");
            relatorio += "nome dev: " + ata.getDev().getNome()+" \n descricao: "+ata.getDescricao()+"\n observacao: "+ata.getObservacao()+" \n data: "+ ata.getData_Ata() +"\n";
        }
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.status(200)
                .header(String.valueOf(headers))
                .header("content-disposition", "filename=\"ata.text\"")
                .header("content-type", "text/txt")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(relatorio);
    }

    @GetMapping(value = "/txt/{codigo}", produces = "image/text")
    public ResponseEntity<byte[]> getFoto(@PathVariable int codigo) {
        byte[] foto = ataRepositorio.getArquivoTxt(codigo);
        if (foto == null) {
            return status(404).build();
        }
        return status(200).body(foto);
    }

    @PatchMapping(value = "/txt/{codigo}")
    public ResponseEntity patchFoto(@PathVariable int codigo,
                                    @RequestParam("file") MultipartFile novaFoto) throws IOException {

        int atualizados = ataRepositorio.atualizarArquivoTxt(codigo, novaFoto.getBytes());
        if (atualizados == 0) {
            return status(404).build();
        }
        return status(200).build();
    }
}


