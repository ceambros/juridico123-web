package br.com.juridico.service;

import br.com.juridico.model.Processo;
import br.com.juridico.repository.ProcessoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Service
public class ProcessoService {

    @Autowired
    ProcessoRepository repository;

    @Transactional
    public List<Processo> findAll() {
        return repository.findAll();
    }

    //TESTES
    @Transactional
    public List<Processo> fcGetProcessosPostgres() {
        return repository.fcGetProcessosPostgres();
    }

    @Transactional
    public void insert(Processo processo) {
        repository.insert(processo);
    }

    @Transactional
    public void delete(Processo processo) {
        repository.delete(processo);
    }
}
