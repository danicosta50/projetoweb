import Util.validarCpf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class validarCpfTeste {

    public validarCpfTeste() {
        // Construtor vazio (ok deixar assim)
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // ✅ Agora os testes estão fora do construtor
    @Test
    public void testCPFValido() {
        assertTrue(validarCpf.validarCpf("123.456.789-00"));
    }

    @Test
    public void testCPFInvalidoFormato() {
        assertFalse(validarCpf.validarCpf("12345678900"));
    }

    @Test
    public void testCPFComLetras() {
        assertFalse(validarCpf.validarCpf("abc.def.ghi-jk"));
    }

    @Test
    public void testCPFNull() {
        assertFalse(validarCpf.validarCpf(null));
    }

    @Test
    public void testCPFComTamanhoErrado() {
        assertFalse(validarCpf.validarCpf("123.456.789-000"));
    }
    
}
