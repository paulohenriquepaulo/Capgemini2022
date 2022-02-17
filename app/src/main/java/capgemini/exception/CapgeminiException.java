package capgemini.exception;

import java.util.HashMap;
import java.util.Map;

public class CapgeminiException extends RuntimeException {

    private Map<String, String> errors;

    public CapgeminiException() {
        this.errors = new HashMap<>();
    }

    public CapgeminiException(String erro, String descricao) {
        this();
        add(erro, descricao);
    }


    public void add(String erro, String descricao) {
        this.errors.put(erro, descricao);
    }

    public Map<String, String> getErrors() {
        return errors;
    }

}
