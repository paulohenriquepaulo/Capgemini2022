package capgemini.questao01.service;

import capgemini.exception.CapgeminiException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EscadaServiceTest {

    @InjectMocks
    private EscadaService escadaService;

    @Test
    public void deveSubirExceptionCapgnimiExceptionQuandoQuantidadeForZero() {
        CapgeminiException capgnimiException =
                assertThrows(CapgeminiException.class, () -> escadaService.escada(0));

        assertNotNull(capgnimiException);
        assertEquals("O número precisar ser maior do que 0.",
                capgnimiException.getErrors().get("erro"));
    }
}

