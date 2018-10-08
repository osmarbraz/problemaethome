import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author osmar
 */
public class ArvoreDerivacaoTestABB {
    
    private GLC xpto;

    public ArvoreDerivacaoTestABB() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        xpto = new GLC("S");

        //Regras
        xpto.insertRegra(new Regra("S",new String[]{"A", "B"}));
        xpto.insertRegra(new Regra("B",new String[]{"B", "B"}));
        xpto.insertRegra(new Regra("B",new String[]{"b"}));
        xpto.insertRegra(new Regra("A",new String[]{"a"}));

        //Não terminal
        xpto.insertNaoTerminal("S");
        xpto.insertNaoTerminal("A");
        xpto.insertNaoTerminal("B");

        //Terminal
        xpto.insertTerminal("a");
        xpto.insertTerminal("b");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testValido1() {
        String teste = "abb";
        System.out.println("teste regra 4 - exemplo 1 " + teste);

        boolean expResult = true;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }

    @Test
    public void testValido2() {
        String teste = "ab";
        System.out.println("teste regra 4 - exemplo 2 " + teste);

        boolean expResult = true;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }

    @Test
    public void testValido3() {
        String teste = "aab";
        System.out.println("teste regra 4 - exemplo 3 " + teste);

        boolean expResult = false;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }
}
