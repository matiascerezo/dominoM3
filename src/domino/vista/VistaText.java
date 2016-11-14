package domino.vista;

/**
 *
 * @author Matias Cerezo
 */
import domino.model.Fitxa;
import domino.model.Jugador;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class VistaText {

    //Declarem l'escaner per recollir les dades más endavant
    private final Scanner lector = new Scanner(System.in);

    /**
     * Mètode per imprimir per pantalla el torn i el nom del jugador.
     *
     * @param torn
     * @param nom
     */
    public void imprimirDadesTorn(int torn, String nom) {
        System.out.println("TORN: " + torn + "\t" + nom);
    }

    /**
     * Mètode per mostrar el menú perquè el jugador al que li toca esculli que
     * jugada vol fer
     */
    public void mostrarMenuJoc() {

        System.out.println("TRIAR JUGADA:\n"
                + "1. Col·locar fitxa.\n"
                + "2. Co·locar dues fitxes dobles.\n"
                + "3. Passar torn.\n"
                + "Opció: ");
    }

    /**
     * Mostra un missatge d'error
     */
    public void errorOpcio() {
        System.out.println("Opció no vàlida");
    }

    /**
     * Mètode per imprimir les fitxes que falten por posar al Jugador X.
     *
     * @param fitxes
     */
    public void imprimirFitxesJugador(List<Fitxa> fitxes) {

        for (int i = 0; i < fitxes.size(); i++) {
            System.out.print(" " + fitxes.get(i).valors[0] + ":" + fitxes.get(i).valors[1] + " ");
        }

    }

    /**
     * Mostra un missatge de quina fitxa vol introduir l'usuari.
     */
    public void mostrarMissatge() {
        System.out.println("Quina fitxa vols introduir? (Ex:1) ");
    }

    /**
     * Mostra un missatge que anirá davant de les fitxes que té l'usuari.
     */
    public void mostrarMissatgeFitxes() {
        System.out.println("Les teves fitxes són: \n");
    }

    /**
     * Mostra un missatge de text seguit del nom del jugador que guanya la
     * partida.
     *
     * @param guanyador
     */
    public void imprimirGuanyador(Jugador guanyador) {
        System.out.println("El guanyador d'aquesta partida és: " + guanyador.getNom());
    }

    /**
     * Mostra un missatge preguntant a l'usuari en que costat vol possar la
     * fitxa.
     */
    public void missatgeCostat() {
        System.out.println("En què costat vols posar la fitxa?");
    }

    /**
     * Mètode per fer la comprovació de que l'opció introduïda es correcte, és a
     * dir, que l'opció introduïda està entre les possibles.
     *
     * @return
     */
    public int comprovarOpcio() {

        int opcio = 0, opcioFinal = 0;
        if (lector.hasNextInt()) {
            opcio = lector.nextInt();
        } else {
            String cadena = lector.nextLine();
            errorOpcio();
        }
        return opcioFinal;
    }

    /**
     * Metode per a imprimir les fitxes que s'han jugat fins ara.
     *
     * @param fitxesJaJugades
     */
    public void imprimirFitxesJugades(Deque<Fitxa> fitxesJaJugades) {

        StringBuilder sbTauler = new StringBuilder();

        for (Fitxa fitxa : fitxesJaJugades) {
            sbTauler.append(" |");
            sbTauler.append(fitxa.getValors()[0]);
            sbTauler.append(":");
            sbTauler.append(fitxa.getValors()[1]);
            sbTauler.append("| ");
        }
        System.out.println(sbTauler);

    }

    /**
     * Mètode que comprova si els caracters que introdueix l'usuari, són
     * caràcters vàlids per a nosaltres.
     *
     * @param costat
     * @return
     */
    public boolean comprovarOpcioCostat(char costat) {

        return costat == 'D' || costat == 'E'
                || costat == 'e' || costat == 'd';
    }

    /**
     * Mètode que demana el costat de la fitxa, aquest mètode utilitza el
     * missatge de "En que costat vols possar la fitxa?" i recull la resposta,
     * fent servir el mètode anterior de si el caràcter es vàlid, assignem de
     * tal forma que sabem com vol possar la fitxa.
     *
     * @return
     */
    public boolean demanarCostat() {
        char esqOdret;
        boolean costat = false;
        do {
            missatgeCostat();
            esqOdret = lector.next().charAt(0);

        } while (comprovarOpcioCostat(esqOdret));

        if (esqOdret == 'E' || esqOdret == 'e') {
            costat = true;
        } else if (esqOdret == 'D' || esqOdret == 'd') {
            costat = false;
        }
        return costat;
    }

    /**
     * Mètode que comprova que la fitxa introduïda compleix la longitud màxima
     * de fitxes (7 ja que tindràn 7 fitxes màxim) i que la fitxa hi és al
     * array.
     *
     * @param fitxa
     * @param longitudFitxes
     * @return
     */
    public boolean comprovarFitxaIntroduida(int fitxa, int longitudFitxes) {
        return (fitxa > 0 && longitudFitxes <= 7);
    }
}
