
public class Principal {

    public static void main(String[] args) {

        ArvoreDerivacao ipe = new ArvoreDerivacao();
        ipe.inserirFilhos("S");
        ipe.inserirFilhos("AB");
        ipe.inserirFilhos("aA");
        ipe.inserirFilhos("a");
        ipe.inserirFilhos("");
        ipe.inserirFilhos("AB");

        System.out.println("\n>Caminhar central");
        ipe.caminhar(1);

        System.out.println("\n>Caminhar pré");
        ipe.caminharPre(1);

        System.out.println("\n>Caminhar pós");
        ipe.caminharPos(1);

        System.out.println("\n>Listar vetor");
        ipe.mostrarVetor();

    }
}
