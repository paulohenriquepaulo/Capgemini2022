package capgemini.questao03.service;

import capgemini.exception.CapgeminiException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AnagramaService {

    /**
     * Método recebe uma String e verifica a parti dessa String
     * quantos anagramas pares podem ser formados.
     *
     * @return Integer - mostrando a quantidade de anagramas
     * pares podem ser formados a partir da palavra passada como
     * parâmetro
     */
    public Integer calcularAnagramas(String palavra) {
        ArrayList<String> anagramas = new ArrayList<String>();
        for (int i = 0; i < palavra.length(); i++) {
            for (int j = 1; j < palavra.length(); j++) {
                if (palavra.charAt(i) == palavra.charAt(j) && i != j && i < j) {
                    if (palavra.charAt(i) == palavra.charAt(i + 1)) {
                        String x = palavra.substring(i, i + 1);
                        anagramas.add(ordenarTrecho(x));
                    } else {
                        String p = palavra.substring(i, j);
                        String a = palavra.substring(i, i + 1);
                        anagramas.add(ordenarTrecho(a));
                        anagramas.add(ordenarTrecho(p));
                    }
                }
            }
        }
        if (anagramas.size() == 0) {
            CapgeminiException ex = new CapgeminiException();
            ex.add("erro", "Esta palavra não contem anagramas pares.");
            throw ex;
        }
        return anagramas.size();
    }

    public String ordenarTrecho(String trecho) {
        char[] caracteres = trecho.toCharArray();
        Arrays.sort(caracteres);
        return new String(caracteres);
    }
}
