package br.com.juridico.controller;

import br.com.juridico.model.Jurisdicao;
import br.com.juridico.model.Processo;
import br.com.juridico.repository.ProcessoRepository;
import br.com.juridico.service.JurisdicaoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import lombok.Setter;
import lombok.Getter;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
@SuppressWarnings("serial")
@Getter
@Setter
public class ProcessoController implements Serializable {

    private Processo processo = new Processo();

    private List<Processo> processos = new ArrayList<>();

    @Inject
    private ProcessoRepository processoRepository;

    @Inject
    JurisdicaoService jurService;

    public void fetchAll() {
        processo = processoRepository.findAll();
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName() + "...........");

    }

    @Transactional
    public void save() {
        System.out.println("Recuperando os processos");
        processos = processoRepository.fcGetProcessosPostgres();
        processos.forEach(processo -> System.out.println(processo.getJurisdicaoNum().getNmJurisdicao() + " *****" + processo.getDsProcesso()));
        System.out.println(processos.size() + " processos recuperados.");
        //System.out.println(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName() + "...........");
    }

    public void testeDeTransacaoJPA() {
        System.out.println("Testando transacao");

        Jurisdicao jur1 = new Jurisdicao();
        jur1.setJurisdicaoNum(1000);
        jur1.setUsAlt("Carlos");
        jur1.setDtAlt(new Date(System.currentTimeMillis()));
        jur1.setNmJurisdicao("TESTE " + jur1.getJurisdicaoNum());

        Jurisdicao jur2 = new Jurisdicao();
        jur2.setJurisdicaoNum(1001);
        jur2.setUsAlt("Carlos");
        jur2.setDtAlt(new Date(System.currentTimeMillis()));
        jur2.setNmJurisdicao("TESTE " + jur2.getJurisdicaoNum());

        Jurisdicao jur3 = new Jurisdicao();
        jur3.setJurisdicaoNum(1002);
        jur3.setUsAlt("Carlos");
        jur3.setDtAlt(new Date(System.currentTimeMillis()));
        jur3.setNmJurisdicao("TESTE " + jur3.getJurisdicaoNum());

        jurService.testeTransacaoJPA(jur1, jur2, jur3);
        System.out.println(jur1 + "INSERIDA COM SUCESSO");
    }

    public void refresh() {
        processo = new Processo();
    }

    /*
    public void edit(Processo processo) {
        this.processo = processo;
    }
     */
    public List<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

}
