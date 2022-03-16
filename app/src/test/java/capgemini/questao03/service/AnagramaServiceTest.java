package capgemini.questao03.service;

import capgemini.desafio.service.AnagramaService;
import capgemini.exception.CapgeminiException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AnagramaServiceTest {

    @InjectMocks
    private AnagramaService service;

    @Test
    void deveSubirExceptionCapgeminiExceptionQuandoPalavraNaoConterAnagramaaPares() {

        CapgeminiException capgnimiException =
                assertThrows(CapgeminiException.class, () -> service.calcularAnagramas("t"));
        assertNotNull(capgnimiException);
        assertEquals("Esta palavra não contem anagramas pares.",
                capgnimiException.getErrors().get("erro"));
    }

    @Test
    void DeveRetornarUmInteiroQuandoPalavraConterAnagramasPares() {
        service.calcularAnagramas("ovo").equals(2);
        service.calcularAnagramas("ifailuhkqq").equals(3);

    }
}