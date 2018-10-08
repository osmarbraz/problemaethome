/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ArvoreDerivacaoTest2 {
    
    private GLC xpto;

    public ArvoreDerivacaoTest2() {
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
        xpto.insertRegra(new Regra("S",new String[]{"a"}));
        xpto.insertRegra(new Regra("B",new String[]{"b"}));
        xpto.insertRegra(new Regra("A",new String[]{"a"}));
        //Não terminais
        xpto.insertNaoTerminal("S");
        xpto.insertNaoTerminal("A");
        xpto.insertNaoTerminal("B");
        //Terminais
        xpto.insertTerminal("a");
        xpto.insertTerminal("b");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testValido1() {
        String teste = "ab";
        System.out.println("teste regra 2 - exemplo 1 " + teste);

        boolean expResult = true;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }

    @Test
    public void testValido2() {
        String teste = "aab";
        System.out.println("teste regra 2 - exemplo 2 " + teste);

        boolean expResult = false;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }

    @Test
    public void testValido3() {
        String teste = "a";
        System.out.println("teste regra 2 - exemplo 3 " + teste);

        boolean expResult = true;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }

    @Test
    public void testValido4() {
        String teste = "b";
        System.out.println("teste regra 2 - exemplo 4 " + teste);

        boolean expResult = false;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }
}
