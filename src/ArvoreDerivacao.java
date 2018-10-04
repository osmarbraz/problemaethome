public class ArvoreDerivacao {

    private String[] arvore = new String[10000];
    private int n;

    public ArvoreDerivacao() {
        this.n = 0;
    }

    public void inserirFilhos(String regra) {
        //Inserindo a raiz
        if (n == 0) {
            inserir(regra);
        } else {
            //Inserindo uma variável
            if (regra.length() == 1) {
                inserir(regra);
                //inserir("");
            } else {
                //Inserindo duas variáveis
                if (regra.length() == 2) {
                    inserir(regra.charAt(0) + "");
                    inserir(regra.charAt(1) + "");
                } else {
                    //Inserindo vazio
                    inserir("");
                }
            }
        }
    }

    private void inserir(String valor) {
        arvore[n] = valor;
        n = n + 1;
    }

    public int pai(int i) {
        return (int) Math.ceil(i / 2.0);
    }

    public void caminhar(int i) {
        if (i <= n) {
            caminhar(2 * i);
            System.out.println("valor=" + arvore[i - 1]);
            caminhar(2 * i + 1);
        }
    }

    public void caminharPre(int i) {
        if (i <= n) {
            System.out.println("valor=" + arvore[i - 1]);
            caminharPre(2 * i);
            caminharPre(2 * i + 1);
        }
    }

    public void caminharPos(int i) {
        if (i <= n) {
            caminharPos(2 * i);
            caminharPos(2 * i + 1);
            System.out.println("valor=" + arvore[i - 1]);
        }
    }

    public void mostrarVetor() {
        for (int i = 0; i < n; i++) {
            System.out.println("arvore[" + i + "]=" + arvore[i]);
        }
    }
}
