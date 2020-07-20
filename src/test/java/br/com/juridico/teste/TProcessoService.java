/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juridico.teste;

import br.com.juridico.conf.JpaConfigurator;
import br.com.juridico.model.Pessoa;
import br.com.juridico.model.Processo;
import br.com.juridico.repository.PessoaRepository;
import br.com.juridico.service.PessoaService;
import br.com.juridico.service.ProcessoService;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public class TProcessoService {
    
    private static PessoaService service;
    private static ProcessoService processoService;
    
    public TProcessoService() {
    }
    
    @BeforeAll
    public static void setUpClass() throws Exception {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(JpaConfigurator.class, PessoaRepository.class, PessoaService.class);
        springContext.scan("br.com.juridico");
        service = (PessoaService) springContext.getBean(PessoaService.class);
        processoService = (ProcessoService) springContext.getBean(ProcessoService.class);
    }
    
    @AfterAll
    public static void tearDownClass() throws Exception {
        System.out.println("AfterAll ... ");
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("BeforeEach ... ");
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("AfterEach ... ");
    }
    
    @Test
    @DisplayName("Teste da anotaton DisplayName")
    public void hello() {
        List<Pessoa> pessoas = service.findAll();
        System.out.println("Quantidade de pessoas recuperadas = " + pessoas.size());
        List<Processo> processos = processoService.fcGetProcessosPostgres();
        processos.forEach(processo -> System.out.println("Processo = " + processo.getDsProcesso()));        
    }
    
    @Test
    @DisplayName("Teste da anotaton DisplayName")
    public void hello2() {
        System.out.println("........................");
    }
}
