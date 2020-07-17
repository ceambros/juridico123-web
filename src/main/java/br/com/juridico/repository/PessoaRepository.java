package br.com.juridico.repository;

import br.com.juridico.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Repository
public class PessoaRepository {

    @PersistenceContext
    EntityManager em;

    public List<Pessoa> findAll() {
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.findAll", Pessoa.class);
        return query.getResultList();
    }
}
