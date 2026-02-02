class Automa1D {

    private int[] striscia;
    private static int regola;

    public Automa1D(int larghezza, int regola) {
        this.striscia = new int[larghezza];
        this.regola = regola;
        striscia[larghezza / 2] = 1; // solo una cella accesa al centro. Ci serve per
        // vedere se si "propaga"
    }

    public static int calcolaStato(int sinistra, int centro, int destra) {
        regola = 110;

        String binario = Integer.toBinaryString(regola);
        char[] n = new char[binario.length()];
        for (int i = 0; i < n.length; i++) {
            n[i] = binario.charAt(i);
            System.out.println(n[i]);
        }

        System.out.println("numero in binario: " + binario);

        // TODO Completa qui: in base a sinistra, centro, destra e la "regola"
        String stringa = Integer.toString(sinistra + centro + destra);
        // devi calcolare il nuovo stato

        switch (stringa) {
            case "110":
                return n[0];
            case "101":
                return n[1];
            case "100":
                return 0;
            case "011":
                return n[0];
            case "010":
                return n[1];
            case "001":
                return n[1];
            default:
                return 0;
        }
    }

    public void nextStato() {
        int[] nuovoStato = new int[striscia.length];

        // TODO Completa qui:
        // per ogni cella, prendi i vicini e calcola il nuovo stato usando
        // "calcolaStato"
        for (int i = 0; i < nuovoStato.length; i++) {
            calcolaStato(nuovoStato[i - 1], nuovoStato[i], nuovoStato[i + 1]);
        }
        striscia = nuovoStato;
    }

    public static void main(String[] args) {
        System.out.println("hello");
        calcolaStato(0, 0, 0);
    }
}