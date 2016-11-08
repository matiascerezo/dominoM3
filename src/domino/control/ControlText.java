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
        //this.joc = new Joc(4,28,7);
        this.vText = new VistaText();
    }

    public int comprovarOpcio() {

        int opcio = 0;
        if (lector.hasNextInt()) {
            opcio = lector.nextInt();
        } else {
            String cadena = lector.next();
            System.out.println("Valor no vàlid.");
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
        System.out.println("Quina fitxa vols introduir? (Ex:1) ");
        int fitxaIntroduir = comprovarOpcio();
        
        
        

    }

    public void afegirDobles() {
        System.out.println("Quina fitxa vols introduir? (Ex:1) ");
        int fitxaIntroduir = comprovarOpcio();
        
    }

    public void passarTorn() {

    }
}
