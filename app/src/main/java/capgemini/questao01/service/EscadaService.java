package capgemini.questao01.service;

import capgemini.exception.CapgeminiException;
import org.springframework.stereotype.Service;

@Service
public class EscadaService {

    public StringBuilder escada(int quantidade) {
        validarQuantidade(quantidade);
        Integer contador = quantidade;
        Integer espaco = quantidade - 1;
        StringBuilder escada = new StringBuilder();

        for (int i = 0; i < contador; i++) {
            for (int j = espaco; j > 0; j--) {
                escada.append(" ");
            }
            espaco--;
            for (int p = 0; p <= i; p++) {
                escada.append("*");
            }
            escada.append("\n");
        }
        return escada;
    }

    private void validarQuantidade(int quantidade) {
        Boolean valido = Boolean.TRUE;
        CapgeminiException ex = new CapgeminiException();
        if (quantidade == 0) {
            valido = Boolean.FALSE;
            ex.add("erro", "O número precisar ser maior do que 0.");
        }
        if (quantidade < 0) {
            valido = Boolean.FALSE;
            ex.add("erro", "O número precisar positivo.");
        }
        if (!valido) {
            throw ex;
        }

    }
}
