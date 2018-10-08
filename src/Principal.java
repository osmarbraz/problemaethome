
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Principal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
	InputParser parser = new InputParser();
	List<GLC> problemas = parser.parseInput(new FileReader("PROGRAMA2.PP"));

        //Testa as instancias
        int i = 1;
        for (GLC problema : problemas) {
            System.out.println("Instancia " + i);
            problema.testarCadeias();
            i = i + 1;
            System.out.println("");
        }

//        GLC xpto = new GLC("S");

//        xpto.insertNaoTerminal("S");
//        xpto.insertNaoTerminal("A");
//        xpto.insertNaoTerminal("B");
//        
//        String[] x1 = {"A","B"};
//        xpto.insertRegra(new Regra("S",x1));
//        String[] x2 = {"B","B"};
//        xpto.insertRegra(new Regra("B",x2));
//        String[] x3 = {"b"};
//        xpto.insertRegra(new Regra("B",x3));
//        String[] x4 = {"a"};
//        xpto.insertRegra(new Regra("A",x4));
//        
//        xpto.insertNaoTerminal("S");
//        xpto.insertNaoTerminal("A");
//        xpto.insertNaoTerminal("B");
//        
//        xpto.insertTerminal("a");
//        xpto.insertTerminal("b");    
//        
//        System.out.println("\n\n>>> Testarcadeia");
//  
//        System.out.println("b="+xpto.validaCadeia("b"));
//        System.out.println("ab="+xpto.validaCadeia("ab"));        
//        System.out.println("abb="+xpto.validaCadeia("abb"));
//        System.out.println("abbbb="+xpto.validaCadeia("abbbb"));
//        System.out.println("aaab="+xpto.validaCadeia("aaab"));

//        GLC xpto = new GLC("S");
//        String[] x1 = {"A", "B"};
//        xpto.insertRegra(new Regra("S", x1));
//        String[] x2 = {"A", "A"};
//        xpto.insertRegra(new Regra("A", x2));
//        String[] x3 = {"b"};
//        xpto.insertRegra(new Regra("B", x3));
//        String[] x4 = {"a"};
//        xpto.insertRegra(new Regra("A", x4));
//
//        xpto.insertNaoTerminal("S");
//        xpto.insertNaoTerminal("A");
//        xpto.insertNaoTerminal("B");
//
//        xpto.insertTerminal("a");
//        xpto.insertTerminal("b");
//
//        System.out.println("\n\n>>> Testarcadeia");
//
//        System.out.println("a=" + xpto.validaCadeia("a"));
//        System.out.println("ab=" + xpto.validaCadeia("ab"));
//        System.out.println("aab=" + xpto.validaCadeia("aab"));
//        System.out.println("aaab=" + xpto.validaCadeia("aaab"));
//        System.out.println("b=" + xpto.validaCadeia("b"));
//        System.out.println("abb=" + xpto.validaCadeia("abb"));

//        GLC xpto = new GLC("S");
//        String[] x1 = {"A", "B"};
//        xpto.insertRegra(new Regra("S", x1));
//        String[] x3 = {"a"};
//        xpto.insertRegra(new Regra("A", x3));
//        String[] x4 = {"b"};
//        xpto.insertRegra(new Regra("B", x4));
//        String[] x2 = {"a"};
//        xpto.insertRegra(new Regra("S", x2));
//
//        xpto.insertNaoTerminal("S");
//        xpto.insertNaoTerminal("A");
//        xpto.insertNaoTerminal("B");
//
//        xpto.insertTerminal("a");
//        xpto.insertTerminal("b");
//
//        System.out.println("\n\n>>> Testarcadeia");
//
//        System.out.println("a=" + xpto.validaCadeia("a"));
//        System.out.println("ab=" + xpto.validaCadeia("ab"));
//        System.out.println("\n\n>>> Gramática");
//        System.out.println("Raiz=" + xpto.getRaiz());
//        xpto.listarRegras();
//        xpto.listarNaoTerminais();
//        xpto.listarTerminais();

    }
}
