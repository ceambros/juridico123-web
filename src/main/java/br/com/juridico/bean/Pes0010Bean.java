package br.com.juridico.bean;

import br.com.juridico.model.Jurisdicao;
import br.com.juridico.model.Pessoa;
import br.com.juridico.service.JurisdicaoService;
import br.com.juridico.service.PessoaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
@ViewScoped
public class Pes0010Bean implements Serializable {

    private List<Pessoa> clientes = new ArrayList<>();

    @Inject
    PessoaService pessoaService;

    @PostConstruct
    public void init() {
        this.clientes = pessoaService.findAll();
    }
}
