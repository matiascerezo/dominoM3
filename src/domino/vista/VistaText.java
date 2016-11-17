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
    public final Scanner lector = new Scanner(System.in);

    /**
     * Mètode per imprimir per pantalla el torn i el nom del jugador.
     *
     * @param jugador
     */
    public void imprimirDadesTorn(Jugador jugador) {
        System.out.println("\n\t\tTé el torn" + ": " + jugador.getNom());
    }

    public void missatgeInicial() {
        System.out.println("\t\tBENVINGUT AL JOC DEL DOMINÓ");
    }

    public void espacioContraBarras() {
        System.out.println("\n////////////////////////////////////////////////////////");
    }

    public void missatgeTauler() {
        System.out.println("\n\t\t\tTAULER\n");
    }

    /**
     * Mètode per mostrar el menú perquè el jugador al que li toca esculli que
     * jugada vol fer
     */
    public void mostrarMenuJoc() {

        System.out.println();
        System.out.print("\nTRIAR JUGADA:\n"
                + "1. Col·locar fitxa.\n"
                + "2. Co·locar dues fitxes dobles.\n"
                + "3. Passar torn.\n"
                + "\nOpció: ");
    }

    /**
     * Mostra un missatge d'error
     */
    public void errorOpcio() {
        System.err.println("OPCIÓ NO VÀLIDA. TRIA UNA JUGADA VÀLIDA.");
    }

    /**
     *
     * @param error
     */
    public void errorDobles(String error) {
        System.err.println((error.equals("pm") ? "\nERROR! HAS SELECCIONAT LA MATEIXA FITXA. "
                : "\nERROR! INTENTES POSSAR DUES FITXES EN EL MATEIX COSTAT."));

    }

    /**
     * Mètode per imprimir les fitxes que falten por posar al Jugador X.
     *
     * @param fitxes
     */
    public void imprimirFitxesJugador(List<Fitxa> fitxes) {

        System.out.println("\nLes teves fitxes són: ");
        for (int i = 0; i < fitxes.size(); i++) {
            System.out.print(" [" + fitxes.get(i).valors[0] + ":" + fitxes.get(i).valors[1] + "] ");
        }

    }

    public int introduirFitxa(List<Fitxa> fitxa) {
        int fitxaIntroduida = 0;
        do {
            if (lector.hasNextInt()) {
                fitxaIntroduida = lector.nextInt();

            } else {
                System.err.println("ERROR! Introdueix una fitxa vàlida.");
                mostrarMissatge();
                String cadena = lector.next();
            }

        } while (!comprovarFitxaIntroduida(fitxaIntroduida, fitxa.size()));

        return fitxaIntroduida - 1;

    }

    /**
     * Mostra un missatge de quina fitxa vol introduir l'usuari.
     */
    public void mostrarMissatge() {
        System.out.println("\nQuina fitxa vols introduir? (Ex:1-7)");
    }

    /**
     * Mostra un missatge després de seleccionar l'opció introduir dues fitxes
     * dobles, i l'altre missatge després d'introduir la primera fitxa.
     *
     * @param fitxa
     */
    public void missatgeFitxesDobles(String fitxa) {
        System.out.println((fitxa.equals("pm") ? "\nQuina es la PRIMERA fitxa que vols introduir? (Ex:1-7) "
                : "\nQuina es la SEGONA fitxa que vols introduir? (Ex:1-7) "));

    }

    /**
     * Mostra un missatge que anirá davant de les fitxes que té l'usuari.
     */
//    public void mostrarMissatgeFitxes() {
//        System.out.println("\nLes teves fitxes són: ");
//    }
    /**
     * Mostra un missatge de text seguit del nom del jugador que guanya la
     * partida.
     *
     * @param jugGuanyador
     */
    public void imprimirGuanyador(Jugador jugGuanyador ) {
        System.out.println();
        System.out.println("\nEl guanyador d'aquesta partida és: " + jugGuanyador.getNom());
    }

    /**
     * Mostra un missatge preguntant a l'usuari en que costat vol possar la
     * fitxa.
     */
    public void missatgeCostat() {
        System.out.println("En què costat vols posar la fitxa? (Ex: E -> Esquerra / D -> Dreta)");
    }

    public void missatgeFitxaCorrecta() {
        System.out.println("\nFITXA INTRODUIDA CORRECTAMENT.\n\n");
    }

    public void missatgeFitxaIncorrecta() {
        System.err.println("\nFITXA NO INTRODUIDA. TORNA A PROVAR-HO AMB UNA FITXA VÀLIDA!\n\n");
    }

    public void missatgePassarTorn() {
        System.out.println("\nS'HA PASSAT EL TORN.");
    }

    //ARREGLAR EL NO PASSAR
    public boolean missatgePreguntaPassarTorn() {
        boolean passarONo = false;
        do {
            System.out.println("VOLS PASSAR EL TORN? (S -> Sí / N -> No)");

            if (lector.hasNext()) {
                String resposta = lector.next();
                if (resposta.toUpperCase().equals("S")) {
                    passarONo = true;
                } else if (resposta.toUpperCase().equals("N")) {
                    passarONo = false;
                } else {
                    System.err.println("ERROR! Introdueix una fitxa vàlida.");
                }
            } else {
                System.out.println("SISPLAU INTRODUEU NOMÉS \"S\" -> Si / \"N\" -> No )");
                int num = lector.nextInt();
                passarONo = true;
            }
        } while (!passarONo);

        return passarONo;
    }

    /**
     * Mètode per fer la comprovació de que l'opció introduïda es correcte, és a
     * dir, que l'opció introduïda està entre les possibles.
     *
     * @return
     */
    public int comprovarOpcio() {
        int opcio = 0;
        if (lector.hasNextInt()) {
            opcio = lector.nextInt();
        } else {
            String cadena = lector.next();
        }
        return opcio;
    }

    /**
     * Metode per a imprimir les fitxes que s'han jugat fins ara.
     *
     * @param fitxesJaJugades
     */
    public void imprimirFitxesJugades(Deque<Fitxa> fitxesJaJugades) {

        StringBuilder sbTauler = new StringBuilder();

        for (Fitxa fitxa : fitxesJaJugades) {
            sbTauler.append(" [");
            sbTauler.append(fitxa.getValors()[0]);
            sbTauler.append(":");
            sbTauler.append(fitxa.getValors()[1]);
            sbTauler.append("] ");
        }
        System.out.println(sbTauler);

    }

    /**
     * Mètode que comprova si els caracters que introdueix l'usuari, són
     * caràcters vàlids per a nosaltres. Passem el parametre a majuscula per fer
     * la comprovació.
     *
     * @param costat
     * @return
     */
    public boolean comprovarOpcioCostat(String costat) {

        return costat.toUpperCase().equals("D") || costat.toUpperCase().equals("E");
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
        String esqOdreta;
        boolean costat = false;
        do {
            missatgeCostat();
            esqOdreta = lector.next();

        } while (!comprovarOpcioCostat(esqOdreta));

        if (esqOdreta.toUpperCase().equals("E")) {
            costat = true;
        } else if (esqOdreta.toUpperCase().equals("D")) {
            costat = false;
        }
        return costat;
    }

    /**
     * Mètode que comprova que la fitxa introduïda compleix la longitud màxima
     * de fitxes (7 ja que tindràn 7 fitxes màxim) i que la fitxa es major a 0,
     * es a dir no pot ser la fitxa 0, ja que no existeix.
     *
     * @param fitxa
     * @param longitudFitxes
     * @return
     */
    public boolean comprovarFitxaIntroduida(int fitxa, int longitudFitxes) {
        return (fitxa >= 1 && fitxa <= 7 && longitudFitxes <= 7);
    }
}
