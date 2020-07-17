package br.com.juridico.service;

import br.com.juridico.model.Pessoa;
import br.com.juridico.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    @Transactional
    public List<Pessoa> findAll() {
        return repository.findAll();
    }

}
