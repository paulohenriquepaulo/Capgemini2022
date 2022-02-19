package capgemini.questao03.controller;

import capgemini.questao03.service.AnagramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnagramaController {

    @Autowired
    AnagramaService service;

    @GetMapping("/Questao03")
    public Integer cadrastroUsuario(String palavra) {
        return service.calcularAnagramas(palavra);
    }
}
