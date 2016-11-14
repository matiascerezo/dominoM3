package domino.control;

import domino.model.Fitxa;
import domino.model.Joc;
import domino.model.Jugador;
import domino.model.Torn;
import domino.vista.VistaText;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Matias Cerezo
 */
public class ControlText {

    
    private final Joc joc;
    private final VistaText vText;
    private final Torn torn;
    private Jugador jugador;
    private Fitxa fitxa;

    private final Scanner lector = new Scanner(System.in);

    public ControlText(Joc joc, VistaText vText, Torn torn) {
        this.joc = new Joc(4,28,7);
        this.vText = new VistaText();
        this.torn = new Torn(joc);

    }
    
    public void iniciar() {

        while (!joc.isFinalitzat()) {
 
            vText.mostrarMissatgeFitxes();
            vText.imprimirFitxesJugador((List<Fitxa>) fitxa);
            vText.mostrarMenuJoc();
            triarJugada(vText.comprovarOpcio());
        }
    }
    
    public void triarJugada(int opcio) {

        switch (opcio) {
            case 1:
                afegirUnaFitxa();
                break;
            case 2:
                afegirDobles();
                break;
            case 3:
                torn.passar();
                break;
            default:
               vText.errorOpcio();
               break;
        }
    }

    public void afegirUnaFitxa() {

        Fitxa f = null;
        vText.mostrarMissatge();
        int fitxaIntroduir = vText.comprovarOpcio();
        torn.colocarUnaFitxa(f, true);

        joc.actualitzarEstat();
    }

    public void afegirDobles() {

        
    }

}
