
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final int LINHA_RAIZ = 1;
    private static final int LINHA_NAOTERMINAIS = 2;
    private static final int LINHA_TERMINAIS = 3;
    private static final int LINHA_PRODUCOES = 4;
    private static final int LINHA_PARAVRAS = 5;

    public List<GLC> parseEntrada(java.io.Reader input) throws IOException {

        List<GLC> problemas = new ArrayList<GLC>();

        int tipoLinha = LINHA_RAIZ;
        GLC g = null;

        //Scanner reader = new Scanner(input);
        BufferedReader reader = new BufferedReader(input);
        //while (reader.ready()) {
        String linha = reader.readLine();
        //String linha = reader.nextLine();
        while ((linha != null) && (!linha.equals(""))) {
            //String linha = reader.readLine();
            //raiz
            if (tipoLinha == LINHA_RAIZ) {
                g = new GLC(linha);
                tipoLinha = LINHA_NAOTERMINAIS;
            } //nao terminais
            else if (tipoLinha == LINHA_NAOTERMINAIS) {
                char[] parte = linha.toCharArray();
                for (int i = 0; i < parte.length; i++) {
                    g.insertNaoTerminal(parte[i] + "");
                }
                tipoLinha = LINHA_TERMINAIS;
            } //terminais
            else if (tipoLinha == LINHA_TERMINAIS) {

                char[] parte = linha.toCharArray();
                for (int i = 0; i < parte.length; i++) {
                    g.insertTerminal(parte[i] + "");
                }
                tipoLinha = LINHA_PRODUCOES;
            } //producoes
            else if (tipoLinha == LINHA_PRODUCOES) {
                if ("# -> #".equalsIgnoreCase(linha)) {
                    tipoLinha = LINHA_PARAVRAS;
                } else {
                    g.insertRegra(new Regra(linha));

                }
            } //palavras
            else if (tipoLinha == LINHA_PARAVRAS) {
                if ("#".equalsIgnoreCase(linha)) {
                    tipoLinha = LINHA_RAIZ;

//                    g.listarNaoTerminais();
//                    g.listarTerminais();                    
//                    g.listarRegras();
//                    g.listarCadeias();
                    problemas.add(g);
                } else {
                    //Adiciona nova cadeia de teste
                    g.getCadeias().add(linha);
                }
            }
            linha = reader.readLine();
            //linha = reader.nextLine();
        }
        return problemas;
    }
}
