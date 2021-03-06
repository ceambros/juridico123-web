package br.com.juridico.repository;

import br.com.juridico.model.Processo;
import br.com.juridico.util.DateUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Repository
public class ProcessoRepository {

    @PersistenceContext
    EntityManager em;

    public List<Processo> findAll() {
        return em.createNamedQuery("Processo.findAll", Processo.class).getResultList();
    }

    public Processo findById(Integer processoNum) {
        return em.find(Processo.class, processoNum);
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
        TypedQuery<Processo> q = em.createNamedQuery("fcGetProcessos", Processo.class);
        List<Processo> processos = q.getResultList();
        return processos;
    }

    public void insert(Processo processo) {

        //Chamando procedure - N�o funcionou
        /*StoredProcedureQuery procedure = em.createNamedStoredProcedureQuery("Processo.insert")
                .setParameter("p_num", processo.getProcessoNum());
        procedure.execute();*/
        
        /*
        StoredProcedureQuery call = em.createStoredProcedureQuery("processo_insert")
                .registerStoredProcedureParameter("p_num", Integer.class, ParameterMode.INOUT).setParameter("p_num", processo.getProcessoNum())
                .registerStoredProcedureParameter("p_codigo_barras", String.class, ParameterMode.IN).setParameter("p_codigo_barras", processo.getCodBarras())
                .registerStoredProcedureParameter("p_num_processo", String.class, ParameterMode.IN).setParameter("p_num_processo", processo.getNumProcesso())
                .registerStoredProcedureParameter("p_ds_processo", String.class, ParameterMode.IN).setParameter("p_ds_processo", processo.getDsProcesso())
                .registerStoredProcedureParameter("p_cd_tipo_cliente", String.class, ParameterMode.IN).setParameter("p_cd_tipo_cliente", processo.getCdTipoCliente().toString())
                .registerStoredProcedureParameter("p_sg_liminar", String.class, ParameterMode.IN).setParameter("p_sg_liminar", processo.getSgLiminar().toString())
                .registerStoredProcedureParameter("p_dt_abertura", Date.class, ParameterMode.IN).setParameter("p_dt_abertura", processo.getDtAbertura())
                .registerStoredProcedureParameter("p_dt_cadastro", Date.class, ParameterMode.IN).setParameter("p_dt_cadastro", DateUtil.getDate())
                .registerStoredProcedureParameter("p_cd_sit", String.class, ParameterMode.IN).setParameter("p_cd_sit", processo.getCdSit().toString())
                .registerStoredProcedureParameter("p_acao_num", Integer.class, ParameterMode.IN).setParameter("p_acao_num", processo.getAcaoNum().getAcaoNum())
                .registerStoredProcedureParameter("p_jurisdicao_num", Integer.class, ParameterMode.IN).setParameter("p_jurisdicao_num", processo.getJurisdicaoNum().getJurisdicaoNum())
                .registerStoredProcedureParameter("p_vara_num", Integer.class, ParameterMode.IN).setParameter("p_vara_num", processo.getVaraNum().getVaraNum())
                .registerStoredProcedureParameter("p_comarca_num", Integer.class, ParameterMode.IN).setParameter("p_comarca_num", processo.getComarcaNum().getComarcaNum())
                .registerStoredProcedureParameter("p_natureza_num", Integer.class, ParameterMode.IN).setParameter("p_natureza_num", processo.getNaturezaNum().getNaturezaNum())
                .registerStoredProcedureParameter("p_fase_item_num", Integer.class, ParameterMode.IN).setParameter("p_fase_item_num", processo.getFaseItemNum().getItemNum())
                .registerStoredProcedureParameter("p_us_alt", String.class, ParameterMode.IN).setParameter("p_us_alt", processo.getUsAlt());
        call.execute();

        processo.setProcessoNum((Integer) call.getOutputParameterValue("p_num"));
        */
                
        
        processo.setDtCadastro(DateUtil.getDate());
        processo.setDtAlt(DateUtil.getDate());        
        em.merge(processo);
    }

    @Transactional
    public void delete(Processo processo) {

        StoredProcedureQuery call = em.createStoredProcedureQuery("processo_delete")
                .registerStoredProcedureParameter("p_num", Integer.class, ParameterMode.IN).setParameter("p_num", processo.getProcessoNum())
                .registerStoredProcedureParameter("p_erro", String.class, ParameterMode.OUT);
        call.execute();

    }
}
