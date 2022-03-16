package capgemini.desafio.controller;

import capgemini.desafio.service.EscadaService;
import capgemini.desafio.model.Usuario;
import capgemini.desafio.service.CadastroService;
import capgemini.desafio.service.AnagramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Desafio01Controller {

    @Autowired
    private EscadaService escadaService;

    @GetMapping("/Questao01")
    public StringBuilder converterNumero(int tamanho) {
        return escadaService.escada(tamanho);
    }

    @Autowired
    CadastroService cadastroService;

    @GetMapping("/Questao02")
    public String cadrastroUsuario(String nome, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        return cadastroService.cadastrar(usuario);
    }

    @Autowired
    AnagramaService anagramaService;

    @GetMapping("/Questao03")
    public Integer cadrastroUsuario(String palavra) {
        return anagramaService.calcularAnagramas(palavra);
    }
}