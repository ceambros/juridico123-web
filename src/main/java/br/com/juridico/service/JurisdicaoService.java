package br.com.juridico.service;

import br.com.juridico.model.Jurisdicao;
import br.com.juridico.repository.JurisdicaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Service
public class JurisdicaoService {

    @Autowired
    JurisdicaoRepository repository;

    @Transactional
    public void testeTransacaoJPA(Jurisdicao jur1, Jurisdicao jur2, Jurisdicao jur3) {
        repository.testeTransacaoJPA(jur1);
        repository.testeTransacaoJPA(jur2);
        repository.testeTransacaoJPA(jur3);
    }

    @Transactional
    public List<Jurisdicao> findAll() {
        return repository.findAll();
    }
}
