package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Criterio;
import br.edu.infnet.domain.model.Vaga;
import br.edu.infnet.domain.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/vagas"})
public class VagaController {

    @Autowired
    private VagaRepository vagaRepository;


    @GetMapping(path = "/usuario/{usuarioId}")
    public ResponseEntity listaUsuarioPorId(@PathVariable Integer usuarioId) {
        List<Vaga> lista = vagaRepository.findAllByIdUsuario(usuarioId);
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(path = "/cargo/{busca}")
    public ResponseEntity listaPorCargo(@PathVariable String busca) {
        ResponseEntity resposta = ResponseEntity.notFound().build();
        try {
            List<Vaga> lista = vagaRepository.buscaCargoContainingIgnoreCase(busca);
            if (!lista.isEmpty()) {
                resposta = ResponseEntity.ok().body(lista);
            }
        } catch (Exception e) {
        }
        return resposta;
    }

    @GetMapping(path = "/cidade/{busca}")
    public ResponseEntity listaPorCidade(@PathVariable String busca) {
        ResponseEntity resposta = ResponseEntity.notFound().build();
        try {
            List<Vaga> lista = vagaRepository.buscaCidadeContainingIgnoreCase(busca);
            if (!lista.isEmpty()) {
                resposta = ResponseEntity.ok().body(lista);
            }
        } catch (Exception e) {
        }
        return resposta;
    }

    @PostMapping
    public ResponseEntity publicarVaga(@RequestBody Vaga vaga) {
        ResponseEntity resposta = ResponseEntity.badRequest().build();
        List<Criterio> listaCriterio = vaga.getListaCriterio();
        if (listaCriterio != null && !listaCriterio.isEmpty()) {
            for (Criterio criterio : listaCriterio) {
                criterio.setVaga(vaga);
            }

            Vaga vagaGravada = vagaRepository.save(vaga);
            resposta = ResponseEntity.status(HttpStatus.CREATED).body(vagaGravada);
        }
        return resposta;

    }
}