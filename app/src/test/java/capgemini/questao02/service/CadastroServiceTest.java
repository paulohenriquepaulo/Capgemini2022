package capgemini.questao02.service;

import capgemini.exception.CapgeminiException;
import capgemini.questao02.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CadastroServiceTest {

    @InjectMocks
    private CadastroService service;

    @Test
    public void deveEfetuarCadastroQuandoSenhaForForte() {
        Usuario usuario = new Usuario();
        usuario.setSenha("T3stesenh@forte");
        service.cadastrar(usuario).equals("Cadastro efetuado com sucesso.");
    }

    @Test
    public void deveSubirExceptionCapgeminiExceptionQuandoSenhaNaoConterDigitoNumerico() {
        Usuario usuario = new Usuario();
        usuario.setSenha("Senhaerrad@");
        CapgeminiException capgnimiException =
                assertThrows(CapgeminiException.class, () -> service.cadastrar(usuario));

        assertNotNull(capgnimiException);
        assertEquals("Contém no mínimo 1 digito númerico",
                capgnimiException.getErrors().get("erro"));
    }

    @Test
    public void deveSubirExceptionCapgeminiExceptionQuandoSenhaNaoConterLetraMaiusculo() {
        Usuario usuario = new Usuario();
        usuario.setSenha("senha3rrad@");
        CapgeminiException capgnimiException =
                assertThrows(CapgeminiException.class, () -> service.cadastrar(usuario));

        assertNotNull(capgnimiException);
        assertEquals("Contém no mínimo 1 letra em maiúsculo.",
                capgnimiException.getErrors().get("erro"));
    }

    @Test
    public void deveSubirExceptionCapgeminiExceptionQuandoSenhaNaoConterLetraMinuscula() {
        Usuario usuario = new Usuario();
        usuario.setSenha("SENH@3ERRADA");
        CapgeminiException capgnimiException =
                assertThrows(CapgeminiException.class, () -> service.cadastrar(usuario));

        assertNotNull(capgnimiException);
        assertEquals("Contém no mínimo 1 letra em minúsculo.",
                capgnimiException.getErrors().get("erro"));
    }

    @Test
    public void deveSubirExceptionCapgeminiExceptionQuandoSenhaNaoTiveCaracterEspecial() {
        Usuario usuario = new Usuario();
        usuario.setSenha("Senha3rrada");
        CapgeminiException capgnimiException =
                assertThrows(CapgeminiException.class, () -> service.cadastrar(usuario));

        assertNotNull(capgnimiException);
        assertEquals("Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+.",
                capgnimiException.getErrors().get("erro"));
    }

    @Test
    public void deveSubirExceptionCapgeminiExceptionQuandoSenhaForMenorQueSeisCaracteres() {
        Usuario usuario = new Usuario();
        usuario.setSenha("S3nh@");
        CapgeminiException capgnimiException =
                assertThrows(CapgeminiException.class, () -> service.cadastrar(usuario));

        assertNotNull(capgnimiException);
        assertEquals("Possui no mínimo 6 caracteres. Falta 1 caracteres",
                capgnimiException.getErrors().get("erro"));
    }
}