package capgemini.questao02.controller;

import capgemini.questao02.model.Usuario;
import capgemini.questao02.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroController {

    @Autowired
    CadastroService service;

    @GetMapping("/Questão02")
    public String cadrastroUsuario(String nome, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        return service.cadastrar(usuario);
    }
}
