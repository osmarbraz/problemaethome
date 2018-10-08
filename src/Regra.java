
public class Regra {

    private String naoTerminal;
    private String[] regra;

    public Regra() {
        this("", null);
    }

    public Regra(String naoTerminal, String[] regra) {
        this.naoTerminal = naoTerminal;
        this.regra = regra;
    }

    public String getNaoTerminal() {
        return naoTerminal;
    }

    public void setNaoTerminal(String naoTerminal) {
        this.naoTerminal = naoTerminal;
    }

    public String[] getRegra() {
        return regra;
    }

    public void setRegra(String[] regra) {
        this.regra = regra;
    }

}
