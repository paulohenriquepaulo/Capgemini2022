package capgemini.questao03.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class AnagramaService {

    public Integer calcularAnagramas(String palavra) {
        Set<String> anagramas = new HashSet<>();
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
        return anagramas.size();
    }

    public String ordenarTrecho(String trecho) {
        char[] caracteres = trecho.toCharArray();
        Arrays.sort(caracteres);
        return new String(caracteres);
    }
}
