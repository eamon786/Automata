class Automa2D {

    private int[][] striscia;

    public Automa2D(int larghezza, int altezza) {
        this.striscia = new int[larghezza][altezza];
        striscia[altezza / 2][larghezza / 2] = 0; // solo una cella accesa al centro. Ci serve per
        striscia[0][1] = 1;
        striscia[1][1] = 1;
        striscia[1][0] = 1;
        striscia[1][2] = 1;
        striscia[2][1] = 1;
        striscia[2][0] = 1;
        striscia[2][2] = 1;


        // vedere se si "propaga"
    }

    public int calcolaStato(int[][] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }

        if (arr[1][1] == 1) {
            count--;
            if (count < 2 || count > 3) {
                return 0;
            }
            return 1;
        }
        if (count == 3) {
            return 1;
        }

        return 0;

    }

    public void nextStato() {
        int[][] nuovoStato = new int[striscia.length][striscia[0].length];
        int count = 0;

        // TODO Completa qui:
        // per ogni cella, prendi i vicini e calcola il nuovo stato usando
        // "calcolaStato"
        int[][] arrT = new int[2][2];
        for (int i = 1; i < striscia.length - 1; i++) {
            for (int j = 1; j < striscia[0].length - 1; j++) {

                for (int j2 = 0; j2 < arrT.length; j2++) {
                    for (int k = 0; k < arrT.length; k++) {
                        arrT[j2][k] = striscia[i][j];
                    }
                }
                nuovoStato[i][j] = calcolaStato(arrT);

            }
        }

        striscia = nuovoStato;
    }

    public void stampa() {

        for (int i = 0; i < striscia.length; i++) {
            for (int j = 0; j < striscia.length; j++) {
                System.out.print(striscia[i][j] == 1 ? "█" : " ");

            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Automa2D ac = new Automa2D(150, 200);
        
        for (int i = 0; i < 30; i++) {
            ac.stampa();
            ac.nextStato();
        }

    }
}