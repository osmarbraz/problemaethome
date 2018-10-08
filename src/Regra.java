
public class Regra {

    private String naoTerminal;
    private String[] regra;

    public Regra() {
        this("", null);
    }

    public Regra(String linha) {       
        String[] vet = linha.split(" -> ");
        //Não terminal
        this.naoTerminal = vet[0];
        
        //Somente uma regra de produção
        if (vet[1].length() == 1) {            
            this.regra = new String[1];
            String parte = String.valueOf(vet[1].trim());            
            this.regra[0] = String.valueOf(vet[1].trim());            
        } else {            
            this.regra = new String[2];
            this.regra[0] = String.valueOf(vet[1].charAt(0));
            this.regra[1] = String.valueOf(vet[1].charAt(1));
        }
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
