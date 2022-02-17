package capgemini.questao01.controller;

import capgemini.questao01.service.EscadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EscadaController {

    @Autowired
    private EscadaService service;

    @GetMapping("/Questao01")
    public StringBuilder converterNumero(int quantidade) {
        return service.escada(quantidade);
    }
}