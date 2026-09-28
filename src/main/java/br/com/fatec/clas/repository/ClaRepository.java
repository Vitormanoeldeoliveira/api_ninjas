package br.com.fatec.clas.repository;

import br.com.fatec.clas.model.Cla;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClaRepository extends JpaRepository<Cla, Long> {

    // Query Method
    Cla findByNome (String nome);

    List<Cla> findByDescricaoContaining (String descricao);

}
