class Automa1D {

    private int[] striscia;
    private int regola;

    public Automa1D(int larghezza, int regola) {
        this.striscia = new int[larghezza];
        this.regola = regola;
        striscia[larghezza / 2] = 1; // solo una cella accesa al centro. Ci serve per
        // vedere se si "propaga"
    }

    public int calcolaStato(int sinistra, int centro, int destra, int regola) {
        // regola = 110;

        String binario = Integer.toBinaryString(regola);
        char[] n = new char[binario.length()];
        for (int i = 0; i < n.length; i++) {
            n[i] = binario.charAt(i);
            
        }

        // System.out.println("numero in binario: " + binario);

        // TODO Completa qui: in base a sinistra, centro, destra e la "regola"
        String stringa = "" + sinistra + "" + centro +"" + destra;
        // devi calcolare il nuovo stato
       // System.out.println(stringa);

        switch (stringa) {
            case "110":
                return n[0] - '0';
            case "101":
                return n[1] - '0';
            case "100":
                return n[2] - '0';
            case "011":
                return n[3] - '0';
            case "010":
                return n[4] - '0';
            case "001":
                return n[5] - '0';
            default:
                return 0;
        }
    }

    public void nextStato() {
        int[] nuovoStato = new int[striscia.length];

        // TODO Completa qui:
        // per ogni cella, prendi i vicini e calcola il nuovo stato usando
        // "calcolaStato"
        
        for (int i = 1; i < nuovoStato.length - 1; i++) {
            int cal = calcolaStato(striscia[i - 1], striscia[i], striscia[i + 1], regola);
            nuovoStato[i] = cal;
        }
        striscia = nuovoStato;

    
    }

    public void stampa() {
        for (int c : striscia) {
            System.out.print(c == 1 ? "█" : " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Automa1D ac = new Automa1D(500, 110);
        for (int i = 0; i < 30; i++) {
            ac.stampa();
            ac.nextStato();
        }

    }
}