
import java.util.ArrayList;

public class GLC {

    private ArrayList<String> V[];
    private ArrayList<String> T[];
    private ArrayList<Producao> producao;
    private String raiz;

    public ArrayList<String>[] getV() {
        return V;
    }

    public void setV(ArrayList<String>[] V) {
        this.V = V;
    }

    public ArrayList<String>[] getT() {
        return T;
    }

    public void setT(ArrayList<String>[] T) {
        this.T = T;
    }

    public ArrayList<Producao> getProducao() {
        return producao;
    }

    public void setProducao(ArrayList<Producao> producao) {
        this.producao = producao;
    }

    public String getRaiz() {
        return raiz;
    }

    public void setRaiz(String raiz) {
        this.raiz = raiz;
    }

}
