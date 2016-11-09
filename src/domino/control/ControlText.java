package domino.control;

import domino.model.Joc;
import domino.model.Torn;
import domino.vista.VistaText;
import java.util.Scanner;

/**
 *
 * @author Matias Cerezo
 */
public class ControlText {

    private final Joc joc;
    //private final VistaText vText;

    private final Scanner lector = new Scanner(System.in);

    public ControlText(Joc joc, VistaText vText, Torn torn) {
        this.joc = joc;
        //this.joc = new Joc(4,28,7);
        //this.vText = new VistaText();

    }

}
