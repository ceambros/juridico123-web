package br.com.juridico.repository;

import br.com.juridico.model.Processo;
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
public class ProcessoRepository {

    @PersistenceContext
    EntityManager em;

    public Processo findAll() {
        Integer id = 501;
        return em.find(Processo.class, id);
    }

    /*
    //Não converte para o tipo de objeto correto.
    @Transactional
    public List<Object[]> getProcessosPostgres() {
        StoredProcedureQuery query = em
                .createStoredProcedureQuery("get_processos")
                .registerStoredProcedureParameter(1, Processo.class, ParameterMode.REF_CURSOR);
        List<Object[]> processos = query.getResultList();
        return processos;
    }
     */
    public List<Processo> fcGetProcessosPostgres() {
        TypedQuery<Processo> q = em
                .createNamedQuery("fcGetProcessos", Processo.class);
        List<Processo> processos = q.getResultList();
        return processos;
    }
}
