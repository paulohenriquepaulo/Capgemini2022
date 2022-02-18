package capgemini.questao03.service;

import capgemini.exception.CapgeminiException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AnagramaService {

    public Integer calcularAnagramas(String palavra) {
        Boolean valido = Boolean.TRUE;
        ArrayList<String> anagramas = new ArrayList<String>();
        for (int i = 0; i < palavra.length(); i++) {
            for (int j = 1; j < palavra.length(); j++) {
                if (palavra.charAt(i) == palavra.charAt(j) && i != j && i < j) {
                    if (palavra.charAt(i) == palavra.charAt(i + 1)) {
                        String x = palavra.substring(i, i + 1);
                        anagramas.add(ordenarTrecho(x));
                    } else {
                        String y = palavra.substring(i, j);
                        String h = palavra.substring(i, i + 1);
                        anagramas.add(ordenarTrecho(h));
                        anagramas.add(ordenarTrecho(y));
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
