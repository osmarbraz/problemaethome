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
public class ArvoreDerivacaoTest1 {

    public ArvoreDerivacaoTest1() {
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

    @Test
    public void testValido1() {
        String teste = "ab";
        System.out.println("teste regra 1 -  exemplo 1 " + teste);

        GLC xpto = new GLC("S");
        String[] x1 = {"A", "B"};
        xpto.insertRegra(new Regra("S", x1));
        String[] x2 = {"b"};
        xpto.insertRegra(new Regra("B", x2));
        String[] x3 = {"a"};
        xpto.insertRegra(new Regra("A", x3));

        xpto.insertNaoTerminal("S");
        xpto.insertNaoTerminal("A");
        xpto.insertNaoTerminal("B");

        xpto.insertTerminal("a");
        xpto.insertTerminal("b");

        boolean expResult = true;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }

    public void testValido2() {
        String teste = "aab";
        System.out.println("teste regra 1 -  exemplo 2 " + teste);

        GLC xpto = new GLC("S");
        String[] x1 = {"A", "B"};
        xpto.insertRegra(new Regra("S", x1));
        String[] x2 = {"b"};
        xpto.insertRegra(new Regra("B", x2));
        String[] x3 = {"a"};
        xpto.insertRegra(new Regra("A", x3));

        xpto.insertNaoTerminal("S");
        xpto.insertNaoTerminal("A");
        xpto.insertNaoTerminal("B");

        xpto.insertTerminal("a");
        xpto.insertTerminal("b");

        boolean expResult = true;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }

    @Test
    public void testValido3() {
        String teste = "a";
        System.out.println("teste regra 1 -  exemplo 3 " + teste);

        GLC xpto = new GLC("S");
        String[] x1 = {"A", "B"};
        xpto.insertRegra(new Regra("S", x1));
        String[] x2 = {"b"};
        xpto.insertRegra(new Regra("B", x2));
        String[] x3 = {"a"};
        xpto.insertRegra(new Regra("A", x3));

        xpto.insertNaoTerminal("S");
        xpto.insertNaoTerminal("A");
        xpto.insertNaoTerminal("B");

        xpto.insertTerminal("a");
        xpto.insertTerminal("b");

        boolean expResult = false;
        boolean result = xpto.validaCadeia(teste);
        assertEquals(expResult, result);
    }
}
