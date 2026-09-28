package br.com.fatec.clas.service;

import br.com.fatec.clas.model.Cla;
import br.com.fatec.clas.repository.ClaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaService {
    
    @Autowired
    private ClaRepository claRepository;

    public Cla cadastrarCla(Cla cla){
        return claRepository.save(cla);
    }

    public List<Cla> listarClas() {
        return claRepository.findAll();
    }

    public Optional<Cla> pesquisarCla (Long id){
        return claRepository.findById(id);
    }

    public Cla pesquisarClaPorNome (String modelo) {
        return claRepository.findByNome(modelo);
    }

    public List<Cla> pesquisarClaPorParteDaDescricao (String modelo) {
        return claRepository.findByDescricaoContaining(modelo);
    }

    public Cla atualizarCla (Long id, Cla claAtualizado) {
        Optional<Cla> claCadastrado = claRepository.findById(id);

        if(claCadastrado.isPresent()){
            Cla cla = claCadastrado.get();

            cla.setNome(claAtualizado.getNome());
            cla.setDescricao(claAtualizado.getDescricao());
            cla.setHabilidade(claAtualizado.getHabilidade());

            return claRepository.save(cla);
        }
        return null;
    }

    public void deletarCla (Long id) {
        claRepository.deleteById(id);
    }
}
