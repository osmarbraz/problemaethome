
public class Principal {

    public static void main(String[] args) {

        ArvoreDerivacao ipe = new ArvoreDerivacao();
        ipe.inserirFilhos("S");
        ipe.inserirFilhos("AB");
        ipe.inserirFilhos("aA");
        ipe.inserirFilhos("a");
        ipe.inserirFilhos("");
        ipe.inserirFilhos("AB");

        System.out.println("\nCaminhar central");
        ipe.caminhar(1);

        System.out.println("\nCaminhar pre");
        ipe.caminharPre(1);

        System.out.println("\nCaminhar pos");
        ipe.caminharPos(1);

        System.out.println("\nListar vetor");
        ipe.mostrarVetor();

    }

}
