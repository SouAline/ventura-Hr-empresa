package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Vaga;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VagaRepository extends CrudRepository<Vaga, Integer> {

    List<Vaga> findAllByIdUsuario(Integer usuarioId);

    List<Vaga> buscaCargoContainingIgnoreCase(String busca);

    List<Vaga> buscaCidadeContainingIgnoreCase(String busca);
}
