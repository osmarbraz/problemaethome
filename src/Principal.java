
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputParser parser = new InputParser();
        //List<GLC> problemas = parser.parseEntrada(new FileReader("PROGRAMA.PP"));
        //List<GLC> problemas = parser.parseEntrada(new FileReader("PROGRAMA2.PP"));
        
        //Para usar o scanner
        List<GLC> problemas = parser.parseEntrada(new InputStreamReader(System.in));
                
        //Testa as instancias
        int i = 1;
        for (GLC problema : problemas) {
            System.out.println("Instancia " + i);
            problema.testarCadeias();
            i = i + 1;
            System.out.println("");

        }
    }
}
