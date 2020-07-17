package br.com.juridico.controller;

import br.com.juridico.model.Jurisdicao;
import br.com.juridico.service.JurisdicaoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Controller;

@Controller
@SuppressWarnings("serial")
@Getter
@Setter
public class JurisdicaoController implements Serializable {

    private List<Jurisdicao> jurisdicoes = new ArrayList<>();

    @Inject
    JurisdicaoService jurisdicaoService;

    @PostConstruct
    public void init() {
        this.jurisdicoes = jurisdicaoService.findAll();
    }

}
