package capgemini.desafio.service;

import capgemini.exception.CapgeminiException;
import org.springframework.stereotype.Service;

@Service
public class EscadaService {

    /**
     * Método recebe um int com o tamanho para a escada,
     *
     * @return StringBuilder - contendo uma quantidade de " * "
     * senquencial e complentando com espaçoos vazios da primeira
     * linha, até não conter mais espaços.
     */
    public StringBuilder escada(int tamanho) {
        validarQuantidade(tamanho);
        Integer contador = tamanho;
        Integer espaco = tamanho - 1;
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

    /**
     * Método recebe um int com o tamanho para a escada,
     *
     * @return Boolean - informando true para senha valida é
     * false para senha invalida.
     */
    private Boolean validarQuantidade(int tamanho) {
        Boolean valido = Boolean.TRUE;
        CapgeminiException ex = new CapgeminiException();
        if (tamanho <= 0) {
            valido = Boolean.FALSE;
            ex.add("erro", "O número precisar ser maior do que 0.");
        }
        if (!valido) {
            throw ex;
        }
        return valido;
    }
}
