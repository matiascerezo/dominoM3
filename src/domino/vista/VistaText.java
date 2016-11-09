package domino.vista;

/**
 *
 * @author Matias Cerezo
 */
import domino.model.Fitxa;
import domino.model.Joc;
import domino.model.Torn;
import java.util.List;
import java.util.Scanner;

public class VistaText {

    private final Scanner lector = new Scanner(System.in);
    private final Torn torn;
    private final Joc joc;

    public VistaText(Torn torn, Joc joc) {
        this.torn = torn;
        this.joc = joc;
    }

    public void iniciar() {

        while (!joc.isFinalitzat()) {
 
            mostrarMissatgeFitxes();
            //imprimirFitxesJugador(fitxes);
            mostrarMenuJoc();
            triarJugada(comprovarOpcio());
        }
    }
        /**
         * Método para imprimir por pantalla el turno y el nombre del jugador.
         *
         * @param torn
         * @param nom
         */
    public void imprimirDadesTorn(int torn, String nom) {
        System.out.println("TORN: " + torn + "\t" + nom);
    }

    /**
     * Método para mostrar el menú para que el jugador al que le toca escoja que
     * jugada quiere hacer
     */
    public void mostrarMenuJoc() {

        System.out.println("TRIAR JUGADA:\n"
                + "1. Col·locar fitxa.\n"
                + "2. Co·locar dues fitxes dobles.\n"
                + "3. Passar torn.\n"
                + "Opció: ");
    }

    public void errorOpcio() {
        System.out.println("Opció no vàlida");
    }

    /**
     * Método para imprimir las fichas que le quedan al jugador por poner.
     *
     * @param fitxes
     */
    public void imprimirFitxesJugador(List<Fitxa> fitxes) {

        for (int i = 0; i < fitxes.size(); i++) {
            System.out.print(" " + fitxes.get(i).valors[0] + ":" + fitxes.get(i).valors[1] + " ");
        }

    }

    public void mostrarMissatge() {
        System.out.println("Quina fitxa vols introduir? (Ex:1) ");
    }

    public void mostrarMissatgeFitxes() {
        System.out.println("Les teves fitxes són: \n");
    }

    public int comprovarOpcio() {

        int opcio = 0;
        if (lector.hasNextInt()) {
            opcio = lector.nextInt();
        } else {
            String cadena = lector.nextLine();
            errorOpcio();
        }
        return opcio;
    }

    public void triarJugada(int opcio) {

        switch (opcio) {
            case 1:
                afegirFitxa();

                break;
            case 2:
                afegirDobles();
                break;
            case 3:
                passarTorn();
                break;
        }
    }

    public void afegirFitxa() {

        mostrarMissatge();
        int fitxaIntroduir = comprovarOpcio();
        //torn.colocarUnaFitxa(f, true);

        joc.actualitzarEstat();
    }

    public void afegirDobles() {

        
    }

    public void passarTorn() {
        torn.passar();
    }

}
