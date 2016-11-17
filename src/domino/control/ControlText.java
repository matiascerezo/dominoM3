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
        for (int i = 0; i < jugadors.length; i++) {
            jugadors[i] = "Jugador " + (i + 1);
        }
    }

    public void iniciar() {
        nomJugadors();
        vText.missatgeInicial();
        joc.iniciar(jugadors);
        torn.inicial();
        joc.torn = joc.getTorn();
        joc.actualitzarEstat();

        do {
            vText.espacioContraBarras();
            vText.imprimirDadesTorn(joc.jugadors[joc.getTorn()]);
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
        
        vText.imprimirFitxesJugador(joc.jugadors[joc.getTorn()].getFitxes());
        vText.mostrarMenuJoc();
    }

    public void triarJugada() {

        boolean opcioIncorrecta;

        do {
            opcioIncorrecta = false;

            switch (vText.comprovarOpcio()) {

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
                    opcioIncorrecta = true;
                    vText.errorOpcio();
                    taulerMenuIFitxes();
                    break;
            }
        } while (opcioIncorrecta);

    }

    /**
     * Mètode per afegir una fitxa individual al tauler. Mostra missatge
     * preguntant quina la fitxa vol introduir l'usuari i el costat, després
     * prova a afegirla (que comprova si es vàlida o no). Si s'ha pogut afegir
     * es mostra un missatge satisfactori pero sino un missatge d'error i torna
     * a preguntar la fitxa que vol introduir.
     */
    public void afegirUnaFitxa() {

        boolean opcioIncorrecta;
        do {
            opcioIncorrecta = false;
            vText.mostrarMissatge();
            int fitxa1 = vText.introduirFitxa(joc.jugadors[joc.getTorn()].getFitxes());
            boolean costat = vText.demanarCostat();

            if (torn.colocarUnaFitxa(joc.getJugadors()[joc.getTorn()].getFitxes().get(fitxa1), costat)) {
                vText.missatgeFitxaCorrecta();
            } else {

                vText.missatgeFitxaIncorrecta();
                if (vText.missatgePreguntaPassarTorn()) {
                    opcioIncorrecta = false;
                    torn.passar();
                }
            }

        } while (opcioIncorrecta);
    }

    public void afegirDobles() {

        boolean opcioIncorrecta;

        do {
            opcioIncorrecta = false;

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
                opcioIncorrecta = true;
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
                        opcioIncorrecta = true;
                        vText.missatgeFitxaIncorrecta();
                        if (vText.missatgePreguntaPassarTorn()) {
                            opcioIncorrecta = false;
                            torn.passar();
                        }
                    }
                } else {
                    vText.errorDobles("missatge2");
                    opcioIncorrecta = true;
                }
            }
        } while (opcioIncorrecta);
    }
}
