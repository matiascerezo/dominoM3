package domino.control;

import domino.model.Joc;
import domino.model.Jugador;
import domino.model.Torn;
import domino.vista.VistaText;

/**
 *
 * @author Matias Cerezo
 */
public class ControlText {

    private final Joc joc;
    private final VistaText vText;
    private final Torn torn;
    private Jugador jugador;
    public String[] jugadors = new String[4];

    //private Fitxa fitxa;
    public ControlText() {
        this.joc = new Joc(4, 28, 7);
        this.vText = new VistaText();
        this.torn = new Torn(joc);

    }

    /**
     * Asignem els noms als jugadors
     */
    public void nomJugadors() {

        jugadors[0] = "Jugador 1";
        jugadors[1] = "Jugador 2";
        jugadors[2] = "Jugador 3";
        jugadors[3] = "Jugador 4";

    }

    public void iniciar() {

        joc.iniciar(jugadors);
        torn.inicial();
        joc.torn = joc.getTorn();
        joc.actualitzarEstat();

        do {
            vText.espacioContraBarras();
            vText.imprimirDadesTorn(joc.getTorn() + 1, joc.jugadors[joc.getTorn()]);
//            System.out.println("\nTauler\n");
//            vText.imprimirFitxesJugades(joc.fitxesJugades);
//            vText.mostrarMissatgeFitxes();
//            vText.imprimirFitxesJugador(joc.jugadors[joc.getTorn()].getFitxes());
//            vText.mostrarMenuJoc();
            taulerMenuIFitxes();
            triarJugada();
            joc.actualitzarEstat();

        } while (!joc.isFinalitzat());

        vText.imprimirGuanyador(joc.trobarGuanyador());
    }

    public void taulerMenuIFitxes() {
        vText.espacioContraBarras();
        vText.missatgeTauler();
        vText.imprimirFitxesJugades(joc.fitxesJugades);
        //vText.mostrarMissatgeFitxes();

        vText.imprimirFitxesJugador(joc.jugadors[joc.getTorn()].getFitxes());
        vText.mostrarMenuJoc();
    }

    public void triarJugada() {

        boolean comprovacio;

        do {
            comprovacio = false;
            int opcio = vText.comprovarOpcio();
            switch (opcio) {

                case 1:
                    afegirUnaFitxa();
                    break;
                case 2:
                    afegirDobles();
                    break;
                case 3:
                    vText.missatgePassarTorn();
                    torn.passar();

                    break;
                default:
                    comprovacio = true;
                    vText.errorOpcio();
                    taulerMenuIFitxes();
                    break;
            }
        } while (comprovacio);

    }

    /**
     * Mètode per afegir una fitxa individual al tauler. Mostra missatge
     * preguntant quina la fitxa vol introduir l'usuari i el costat, després
     * prova a afegirla (que comprova si es vàlida o no). Si s'ha pogut afegir
     * es mostra un missatge satisfactori pero sino un missatge d'error i torna
     * a preguntar la fitxa que vol introduir.
     */
    public void afegirUnaFitxa() {

        boolean comprovacio = false;
        do {
            comprovacio = false;
            vText.mostrarMissatge();
            int fitxa1 = vText.introduirFitxa(joc.jugadors[joc.getTorn()].getFitxes());
            boolean costat = vText.demanarCostat();

            if (torn.colocarUnaFitxa(joc.getJugadors()[joc.getTorn()].getFitxes().get(fitxa1), costat)) {
                vText.missatgeFitxaCorrecta();
            } else {

                vText.missatgeFitxaIncorrecta();
                if (vText.missatgePreguntaPassarTorn()) {
                    comprovacio = false;
                    torn.passar();
                }
            }

        } while (comprovacio);
    }

    public void afegirDobles() {

        boolean comprovacio;

        do {
            comprovacio = false;

            //Inici Fitxa 1
            vText.missatgeFitxesDobles("pm");
            int fitxa1 = vText.introduirFitxa(joc.jugadors[joc.getTorn()].getFitxes());
            boolean costatFitxa1 = vText.demanarCostat();
            //Final Fitxa1

            //Inici Fitxa 2
            vText.missatgeFitxesDobles("mensaje2");
            int fitxa2 = vText.introduirFitxa(joc.jugadors[joc.getTorn()].getFitxes());

            //Comprovació mateixa fitxa
            if (fitxa1 == fitxa2) {
                comprovacio = true;
                vText.errorDobles("pm");

            } else {
                boolean costatFitxa2 = vText.demanarCostat();
                //Final Fitxa 2

                //Comprovació mateix costat
                if (costatFitxa1 != costatFitxa2) {
                    if (torn.colocarDosDobles(joc.getJugadors()[joc.getTorn()].getFitxes().get(fitxa1), costatFitxa1,
                            joc.getJugadors()[joc.getTorn()].getFitxes().get(fitxa2), costatFitxa2)) {

                        vText.missatgeFitxaCorrecta();
                    } else {
                        comprovacio = true;
                        vText.missatgeFitxaIncorrecta();
                        if (vText.missatgePreguntaPassarTorn()) {
                            comprovacio = false;
                            torn.passar();
                        }
                    }
                } else {

                    vText.errorDobles("missatge2");

                    comprovacio = true;
                }
            }
        } while (comprovacio);
    }
}
