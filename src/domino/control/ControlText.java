package domino.control;

import domino.model.Fitxa;
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
            vText.imprimirDadesTorn(joc.getTorn() + 1, joc.jugadors[joc.getTorn()]);
            System.out.println("\nTauler\n");
            vText.imprimirFitxesJugades(joc.fitxesJugades);
            vText.mostrarMissatgeFitxes();
            vText.imprimirFitxesJugador(joc.jugadors[joc.getTorn()].getFitxes());
            vText.mostrarMenuJoc();
            triarJugada(vText.comprovarOpcio());
            joc.actualitzarEstat();

        } while (!joc.isFinalitzat());

        vText.imprimirGuanyador(joc.trobarGuanyador());
    }

    public void triarJugada(int opcio) {

        if (opcio > 0 && opcio <= 3) {
            switch (opcio) {
                case 1:
                    afegirUnaFitxa();
                    break;
                case 2:
                    afegirDobles();
                    break;
                case 3:
                    torn.passar();
                    vText.missatgePassarTorn();
                    break;
            }

        } else {
            vText.errorOpcio();
        }

    }

    public void afegirUnaFitxa() {

        vText.mostrarMissatge();

        int fitxa1 = vText.introduirFitxa(joc.jugadors[joc.getTorn()].getFitxes());
        boolean costat = vText.demanarCostat();

        if (torn.colocarUnaFitxa(joc.getJugadors()[joc.getTorn()].getFitxes().get(fitxa1), costat)) {
            vText.missatgeFitxaCorrecta();
        } else {
            vText.missatgeFitxaIncorrecta();
        }
    }

    public void afegirDobles() {

        //Fitxa 1
        vText.missatgeFitxesDobles("pm");
        int fitxa1 = vText.introduirFitxa(joc.jugadors[joc.getTorn()].getFitxes());
        boolean costatFitxa1 = vText.demanarCostat();

        //Fitxa 2
        vText.missatgeFitxesDobles("mensaje2");
        int fitxa2 = vText.introduirFitxa(joc.jugadors[joc.getTorn()].getFitxes());
        boolean costatFitxa2 = vText.demanarCostat();

        if (torn.colocarDosDobles(jugador.fitxes.get(fitxa1), costatFitxa1, jugador.fitxes.get(fitxa2), costatFitxa2)) {
            vText.missatgeFitxaCorrecta();
        } else {
            vText.missatgeFitxaIncorrecta();
        }
    }
}
