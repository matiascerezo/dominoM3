package domino.control;

import domino.model.Joc;
import domino.vista.VistaText;
import java.util.Scanner;

/**
 *
 * @author Matias Cerezo
 */

public class ControlText {
    
    private final Joc joc;
    private final VistaText vText;

    private final Scanner lector = new Scanner(System.in);

    public ControlText(Joc joc, VistaText vText) {
        this.joc = joc;
        this.vText = vText;
    }
 
    public boolean comprovarOpcio(int opcio) {
       return opcio == lector.nextInt();
    }
    
    public void triarJugada(int opcio) {
        
        switch(opcio) {
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
        
    }
    
    public void afegirDobles() {
        
    }
    
    public void passarTorn() {
        
    }
}
