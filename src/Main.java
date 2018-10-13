
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * http://www.din.uem.br/yandre/TC/CYK-grande.pdf
 *
 * @author osmar
 */
public class Main {

    //Tabela de busca
//     String[][] tabela = new String[255][255];
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        Inicio do cronômetro
//        Cronometro.inicio();
//        long tempoInicio = Cronometro.tempoGasto();
//        
        java.io.Reader input = new FileReader("et.in");
//        java.io.Reader input = new InputStreamReader(System.in);

        //Dados da gramática
        String raiz;
//        List<String> naoTerminais = new ArrayList<String>();
        char[] naoTerminais;
//        List<String> terminais = new ArrayList<String>();
        char[] terminais;
        List<String[]> regras = new ArrayList<String[]>();
        List<String[]> regrasNaoTerminais = new ArrayList<String[]>();
        List<String[]> regrasTerminais = new ArrayList<String[]>();
        List<String> cadeias = new ArrayList<String>();

        //Declara a tabela das regras terminais e instancia as listas
        String rt[];
        //Declara a tabela das regras nao terminais
        char rnt[][];

        //Contador de instacias
        int instancia = 1;

        //Leitura da entrada
        BufferedReader reader = new BufferedReader(input);

        //Leitura da linha
        String linha = reader.readLine();
        while ((linha != null) && (!linha.equals(""))) {

            rt = new String[255];
            rnt = new char[255][255];

            //raiz           
            raiz = linha;

            //Nao terminal
            linha = reader.readLine();
            naoTerminais = linha.toCharArray();

            //Terminais
            linha = reader.readLine();
            terminais = linha.toCharArray();

            //regras
            linha = reader.readLine();
            regras.clear();

            char[] regrasv = linha.toCharArray();
            // A -> AB      A -> B
            // 0123456      012345
            // 0    56
            while ((regrasv[0] != '#') && (regrasv[5] != '#')) {
                if (regrasv.length == 6) {
                    //Lista dos regras não terminais B
                    regrasTerminais.add(new String[]{String.valueOf(regrasv[0]), String.valueOf(regrasv[5]), ""});
                    //concatena os unitários
                    rt[regrasv[5]] += (regrasv[0]);
                } else {
                    //Lista dos regras não terminais BC
                    regrasNaoTerminais.add(new String[]{String.valueOf(regrasv[0]),
                        String.valueOf(regrasv[5]),
                        String.valueOf(regrasv[6])});
                    //marca a matriz dos não terminais
                    rnt[regrasv[5]][regrasv[6]] = regrasv[0];
                }
                linha = reader.readLine();
                regrasv = linha.toCharArray();
            }

            //cadeias
            linha = reader.readLine();
            cadeias.clear();
            while (!"#".equalsIgnoreCase(linha)) {
                cadeias.add(linha);
                linha = reader.readLine();
            }
            linha = reader.readLine();

            //Início dos testes das cadeias
            testarCadeias(instancia, raiz, naoTerminais, terminais, regras, cadeias, rt, rnt, regrasTerminais, regrasNaoTerminais);

            regrasTerminais.clear();
            regrasNaoTerminais.clear();

            instancia += 1;
        }

        //Parada do cronômetro
//        Cronometro.parada();
//        long tempoFim = Cronometro.tempoGasto();
//        System.out.println("Tempo Inicial: " + tempoInicio + " / Tempo Final: " + tempoFim);
    }

    private static String verificaMenorSubcadeia(char[] cadeia, List<String[]> regras, int caracterCadeia) {
        String resp = "";
        for (int i = 0; i < regras.size(); ++i) {
            if (regras.get(i)[1].charAt(0) == cadeia[caracterCadeia]) {
                resp = resp + regras.get(i)[0];
            }
        }
        return resp;
    }

    public static String verificaSubcadeia(String[][] tabela, List<String[]> regras, int inicio, int meio, int fim) {
        String resp = "";
        for (int i = 0; i < regras.size(); ++i) {
            if (tabela[inicio][meio].contains(regras.get(i)[1])) {
                if (tabela[meio + 1][fim].contains(regras.get(i)[2])) {
                    resp = resp + regras.get(i)[0];
                }
            }
        }
        return resp;
    }

    public static void testarCadeias(int instancia, String raiz, char[] naoTerminais, char[] terminais, List<String[]> regras, List<String> cadeias, String[] rt, char[][] rnt, List<String[]> regrasTerminais, List<String[]> regrasNaoTerminais) {
        //mensagem de saída
        System.out.println("Instancia " + instancia);
        for (String cadeia : cadeias) {
            if (validaCadeiaVM(raiz, naoTerminais, terminais, regras, cadeia.toCharArray(), rt, rnt, regrasTerminais, regrasNaoTerminais)) {
                System.out.println(cadeia + " e uma palavra valida");
            } else {
                System.out.println(cadeia + " nao e uma palavra valida");
            }
        }
        System.out.println("");
    }

    /**
     * Cocke-Younger-Kasami
     *
     * Usa uma matriz bidimensional de Strings
     *
     * Mais rápido
     *
     */
    public static boolean validaCadeiaVM(String raiz, char[] naoTerminais, char[] terminais, List<String[]> regras, char[] cadeia, String[] rt, char[][] rnt, List<String[]> regrasTerminais, List<String[]> regrasNaoTerminais) {
        //Tamanho da cadeia
        int n = cadeia.length;
        int qrnt = regrasNaoTerminais.size();

        //Tabela de busca
        String[][] tabela = new String[255][255];

        //Inicializa a matriz
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                tabela[i][j] = "";
            }
        }

        for (int i = 0; i < n; ++i) {
            tabela[i][i] = verificaMenorSubcadeia(cadeia, regrasTerminais, i);
        }
        //System.out.println(imprimirMatriz(tabela, n, n));

        for (int i = 2; i <= n; ++i) {
            for (int inicio = 0; inicio <= n - i; inicio++) {
                int fim = inicio + i - 1;
                for (int meio = inicio; meio <= fim - 1; ++meio) {
                    // Retorna os não terminais possiveis
                    String naoTerminaisPossiveis = verificaSubcadeia(tabela, regrasNaoTerminais, inicio, meio, fim);
                    if (!tabela[inicio][fim].contains(naoTerminaisPossiveis)) {
                        //Adiciona o não terminal da regra na lista 
                        tabela[inicio][fim] += naoTerminaisPossiveis;
                    }
                }
            }
        }

//        System.out.println(imprimirMatriz(tabela, n, n));
        return ((tabela[0][n - 1] != null) && (tabela[0][n - 1].contains(raiz)));
    }

   
    /**
     * Gera uma string formatada com os dados Matriz M.
     *
     * @param M Matriz com os dados a serem exibidos.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String formatada com os dados da matriz.
     */
    public static String imprimirMatriz(String[][] M, int linhas, int colunas) {
        if (linhas != 0 || colunas != 0) {
            String saida = "";
            for (int j = 0; j < colunas; ++j) {
                saida = saida + "  " + String.format("%5d", j);
            }
            saida = "n/m" + saida + "\n";
            for (int i = 0; i < linhas; ++i) {
                String dados = " ";
                for (int j = 0; j < colunas; ++j) {
                    dados = dados + "\t" + M[i][j];
                }
                saida = saida + i + dados + "\n";
            }
            return saida;
        } else {
            return "Matriz vazia!";
        }
    }    
}
