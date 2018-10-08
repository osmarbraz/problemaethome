import java.util.ArrayList;
import java.util.List;

public class GLC {

    //Simbolo incial ou raiz
    private String raiz;
    //V
    private List<String> naoTerminais;
    //T
    private List<String> terminais;
    //Regras de Produções
    private List<Regra> regras;    
    //Lista de palavras a serem testadas
    private List<String> cadeias;

    public GLC(String raiz) {
        this.raiz = raiz;
        naoTerminais = new ArrayList<String>();
        terminais = new ArrayList<String>();
        regras = new ArrayList<Regra>();
        cadeias = new ArrayList<String>();
    }

    public String getRaiz() {
        return raiz;
    }

    public void setRaiz(String raiz) {
        this.raiz = raiz;
    }

    public List<String> getNaoTerminais() {
        return naoTerminais;
    }

    public void setNaoTerminais(List<String> naoTerminais) {
        this.naoTerminais = naoTerminais;
    }

    public List<String> getTerminais() {
        return terminais;
    }

    public void setTerminais(List<String> terminais) {
        this.terminais = terminais;
    }

    public List<Regra> getRegras() {
        return regras;
    }

    public void setRegras(List<Regra> regras) {
        this.regras = regras;
    }

    public List<String> getCadeias() {
        return cadeias;
    }

    public void setCadeias(List<String> cadeias) {
        this.cadeias = cadeias;
    }

    
    
    public void insertNaoTerminal(String naoTerminal) {
        naoTerminais.add(naoTerminal);
    }

    public void listarNaoTerminais() {
        System.out.println("Lista de Nao Terminais");
        for (String naoTerminal : naoTerminais) {
            System.out.println("->" + naoTerminal);
        }
    }

    public String getNaoTerminal(String naoTerminal) {
        for (String itemNaoTerminal : naoTerminais) {
            if (itemNaoTerminal.equals(naoTerminal)) {
                return naoTerminal;
            }
        }
        return null;
    }

    public void insertTerminal(String terminal) {
        terminais.add(terminal);
    }

    public void listarTerminais() {
        System.out.println("Lista de Terminais");
        for (String terminal : terminais) {
            System.out.println("->" + terminal);
        }
    }

    public String getTerminal(String terminal) {
        for (String itemTerminal : terminais) {
            if (itemTerminal.equals(terminal)) {
                return terminal;
            }
        }
        return null;
    }

    public boolean eTerminal(String terminal) {
        return ((getTerminal(terminal) != null) ? true : false);
    }

    public void insertRegra(Regra regra) {
        regras.add(regra);
    }

    public void listarRegras() {
        System.out.println("Lista de Regras nde Produção");
        for (Regra regra : regras) {
            String saida = regra.getNaoTerminal() + "->";
            if (regra.getRegra().length == 1) {
                saida = saida + regra.getRegra()[0];
            } else {
                saida = saida + regra.getRegra()[0] + "," + regra.getRegra()[1];
            }
            System.out.println(saida);
        }
    }

    public Regra getTerminalTemRegra(String terminal) {
        for (Regra itemRegra : regras) {
            //Se existe uma regra com este terminal
            //System.out.println(">>>>>>>>>>>>> terminal=" + naoTerminal);
            if (itemRegra.getRegra()[0].equals(terminal)) {
                //Retorna a regra
                return itemRegra;

            }
        }
        return null;
    }
    
     public void listarCadeias() {
        System.out.println("Lista de Cadeias");
        for (String cadeia : cadeias) {
            System.out.println("->" + cadeia);
        }
    }

    private String verificaMenorSubcadeia(ArrayList<String>[][] tabela, String terminal) {
        String retorno = "";
        for (Regra itemRegra : regras) {
            if (itemRegra.getRegra().length == 1) {
                if (itemRegra.getRegra()[0].equals(terminal)) {
                    retorno = retorno + itemRegra.getNaoTerminal();
                }
            }
        }
        return retorno;
    }

    private void verificaMenorSubcadeia(ArrayList<String>[][] tabela, int i, String terminal) {
        for (Regra itemRegra : regras) {
            if (itemRegra.getRegra().length == 1) {
                if (itemRegra.getRegra()[0].equals(terminal)) {
                    tabela[i][i].add(itemRegra.getNaoTerminal());
                }
            }
        }
    }

    public String verificaSubcadeia(ArrayList<String>[][] tabela, int posInicial, int posFinal, int posDivisao) {
        String retorno = "";
        //Percorre as regras
        for (Regra itemRegra : regras) {
            //Regras de duas variaveis
            if (itemRegra.getRegra().length > 1) {
                //Parte 1 da regra
                String parte1 = itemRegra.getRegra()[0];
                //Parte 2 da regra
                String parte2 = itemRegra.getRegra()[1];
                //Verifica se contem a variável parte1
                boolean primeiro = tabela[posInicial][posDivisao].contains(parte1);
                //Verifica se contem a variável parte1
                boolean segundo = tabela[posDivisao + 1][posFinal].contains(parte2);
                if (primeiro && segundo) {
                    retorno = retorno + itemRegra.getNaoTerminal();
                }
            }
        }
        return retorno;
    }

    /**
     * Cocke-Younger-Kasami
     *
     * @param cadeia
     * @return
     */
    public boolean validaCadeia(String cadeia) {
        //Tamanho da cadeia
        int n = cadeia.length();

        //Tabela de busca
        ArrayList<String>[][] tabela = new ArrayList[n][];

        for (int i = 0; i < n; i++) {
            tabela[i] = new ArrayList[n];
            for (int j = 0; j < n; ++j) {
                tabela[i][j] = new ArrayList<String>();
            }
        }

        for (int i = 0; i < n; i++) {
            //Percorre os terminais
            for (String terminal : terminais) {
                //Pega parte da cadeia                
                String parte = cadeia.charAt(i) + "";
                //Percorre as regras
                for (Regra itemRegra : regras) {
                    //Verifica para as regras com 1 producao
                    if (itemRegra.getRegra().length == 1) {
                        //Se é igual a parte
                        if (itemRegra.getRegra()[0].equals(parte)) {                            
                            //Adiciona o não terminal da regra para a parte que é um terminal
                            tabela[i][i].add(itemRegra.getNaoTerminal());
                        }
                    }
                }

            }
        }

        for (int subCadeia = 2; subCadeia <= n; subCadeia++) {
            for (int posicaoInicial = 0; posicaoInicial <= n - subCadeia; posicaoInicial++) {
                int posicaoFinal = posicaoInicial + subCadeia - 1;
                for (int posicaoDivisao = posicaoInicial; posicaoDivisao <= posicaoFinal - 1; posicaoDivisao++) {
                    //Retorna os não terminais possiveis
                    String naoTerminaisPossiveis = verificaSubcadeia(tabela, posicaoInicial, posicaoFinal, posicaoDivisao);
                    if (!tabela[posicaoInicial][posicaoFinal].contains(naoTerminaisPossiveis) && !naoTerminaisPossiveis.equals("")) {
                        //Adiciona o não terminal da regra na lista 
                        tabela[posicaoInicial][posicaoFinal].add(naoTerminaisPossiveis);
                    }
                }
            }
        }

        //System.out.println(imprimirMatriz(tabela, n, n));
        
        if (tabela[0][n - 1].contains(raiz)) {
            return true;
        }
        return false;
    }

    /**
     * Gera uma string formatada com os dados Matriz M.
     *
     * @param M Matriz com os dados a serem exibidos.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String formatada com os dados da matriz.
     */
    public String imprimirMatriz(ArrayList<String>[][] M, int linhas, int colunas) {
        if (linhas != 0 || colunas != 0) {
            String saida = "";
            for (int j = 0; j < colunas; j++) {
                saida = saida + "\t" + String.format("%5d", j);
            }
            saida = "n/m" + saida + "\n";
            for (int i = 0; i < linhas; i++) {
                String dados = "";
                for (int j = 0; j < colunas; j++) {
                    dados = dados + "\t" + M[i][j];
                }
                saida = saida + i + dados + "\n";
            }
            return saida;
        } else {
            return "Matriz vazia!";
        }
    }
    
    public void testarCadeias(){
//         listarNaoTerminais();
//         listarTerminais();                    
//         listarRegras();
//         listarCadeias();
        
        for (String cadeia : cadeias) {            
            if (validaCadeia(cadeia)){
                System.out.println(cadeia + " e uma palavra valida");
            } else {
                System.out.println(cadeia + " nao e uma palavra valida");
            }                        
        }
    }
}
