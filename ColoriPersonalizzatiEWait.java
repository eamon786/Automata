public class ColoriPersonalizzatiEWait {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    static void barraCaricamento() throws InterruptedException {
        System.out.println(ANSI_YELLOW + "\nBarra di caricamento Classica\n" + ANSI_RESET);
        
        int width = 40;
        for (int i = 0; i <= width; i++) {
            System.out.print("\r [");
            for (int j = 0; j < width; j++) {
                if (j < i) System.out.print(ANSI_GREEN + "█");
                else System.out.print(ANSI_GREEN + "░");
            }
            System.out.print(ANSI_RESET + "] " + ANSI_WHITE + (i * 100 / width) + "%" + ANSI_RESET);
            Thread.sleep(50);
        }
        System.out.println("\n" + ANSI_GREEN + "Caricamento completato!" + ANSI_RESET);
    }

    public static void provaColori() throws InterruptedException {
        System.out.println(ANSI_RED + ANSI_YELLOW_BACKGROUND + "Questo testo è in rosso su fondo giallo!" + ANSI_RESET);

        Thread.sleep(1000); // Aspetto 1 secondo (bisogna mettere "throws InterruptedException sul main")

        System.out.println("Questo testo è normale perché prima ho usato ANSI_RESET!");
        System.out.println(ANSI_PURPLE_BACKGROUND + "Sfondo viola! (in questo print ho messo ANSI_PURPLE_BACKGROUND");
        System.out.println("Anche questo sarà viola finché non metto un reset!");
        System.out.println("Anche questo sarà viola finché non metto un reset!");
        System.out.println("Anche questo sarà viola finché non metto un reset!");
        System.out.println("Anche questo sarà viola finché non metto un reset!");
        System.out.println(ANSI_RESET + "Questo sarà normale");

        try {
            Thread.sleep(1000); // Aspetto 1 secondo
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Possiamo anche \"pulire\" il terminale!");

        System.out.println("Il terminale si autodistruggerà tra...");
        
        for (int i = 5; i > 0; i--) {
            // \r riporta il cursore all'inizio della riga corrente
            System.out.print("\rConto alla rovescia: " + i);
            System.out.flush(); // Forza l'output immediato
            Thread.sleep(1000); // Aspetto 1 secondo
        }

        // 2. Pulizia del terminale
        // \033[H   -> Muove il cursore in riga 1, colonna 1
        // \033[2J  -> Pulisce lo schermo visibile
        // \033[3J  -> CANCELLA lo scrollback (elimina la possibilità di scorrere su)
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        System.out.println("Terminale pulito con successo!");

    }

    public static void main(String[] args) throws InterruptedException {
        // provaColori();

        barraCaricamento();
    }
}
