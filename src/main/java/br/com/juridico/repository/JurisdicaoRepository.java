package br.com.juridico.repository;

import br.com.juridico.model.Jurisdicao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Repository
public class JurisdicaoRepository {

    @PersistenceContext
    EntityManager em;

    public void testeTransacaoJPA(Jurisdicao jurisdicao) {
        em.persist(jurisdicao);
    }

    public List<Jurisdicao> findAll() {
        Query query = em.createNamedQuery("Jurisdicao.findAll");
        List<Jurisdicao> all = query.getResultList();
        return all;
    }
}
