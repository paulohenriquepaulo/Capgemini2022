package capgemini.questao02.service;

import capgemini.exception.CapgeminiException;
import capgemini.questao02.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {
    CapgeminiException ex = new CapgeminiException();

    public String fazerLodin(Usuario usuario) {
        String texto = null;
        if (senhaForte(usuario)) {
            texto = "Cadastro efetuado com sucesso.";
        }
        return texto;
    }

    private Boolean senhaForte(Usuario usuario) {
        Boolean erro = Boolean.TRUE;
        Boolean sucesso = Boolean.TRUE;
        Boolean achouNumero = Boolean.FALSE;
        Boolean achouMaiuscula = Boolean.FALSE;
        Boolean achouMinuscula = Boolean.FALSE;
        Boolean achouSimbolo = Boolean.FALSE;
        String[] caracteres = {"!", "@", "#", "$", "%", "^", "&", "*",
                "(", ")", "-", "+"};
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        if (usuario.getSenha().length() >= 6) {
            for (char c : usuario.getSenha().toCharArray()) {
                for (int k = 0; k < caracteres.length; k++) {
                    if (usuario.getSenha().contains(caracteres[k])) {
                        achouSimbolo = Boolean.TRUE;
                        erro = Boolean.FALSE;
                    }
                }
                for (int k = 0; k < numeros.length; k++) {
                    if (usuario.getSenha().contains(numeros[k])) {
                        achouNumero = Boolean.TRUE;
                        erro = Boolean.FALSE;
                    }
                }
                if (c >= 'A' && c <= 'Z') {
                    achouMaiuscula = Boolean.TRUE;
                    erro = Boolean.FALSE;
                }
                if (c >= 'a' && c <= 'z') {
                    achouMinuscula = Boolean.TRUE;
                    erro = Boolean.FALSE;
                }
            }
            if (!achouNumero) {
                ex.add("erro", "Contém no mínimo 1 digito númerico");
                erro = Boolean.TRUE;
            }
            if (!achouMinuscula) {
                ex.add("erro", "Contém no mínimo 1 letra em minúsculo.");
                erro = Boolean.TRUE;
            }
            if (!achouMaiuscula) {
                ex.add("erro", "Contém no mínimo 1 letra em maiúsculo.");
                erro = Boolean.TRUE;
            }
            if (!achouSimbolo) {
                ex.add("erro", "Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+.");
                erro = Boolean.TRUE;
            }
        } else {
            ex.add("erro", "Possui no mínimo 6 caracteres.");
            erro = Boolean.TRUE;
        }
        if (erro) {
            throw ex;
        }
        return sucesso;
    }
}
