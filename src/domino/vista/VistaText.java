package domino.vista;

/**
 *
 * @author Matias Cerezo
 */

public class VistaText {

    public void imprimirDadesTorn(int torn, String nom) {
        System.out.println("TORN: " +torn + "\t" + nom);
    }
            
    public void mostrarMenuJoc() {
        System.out.println("TRIAR JUGADA:\n" +
                "1. Col·locar fitxa.\n" +
                "2. Co·locar dues fitxes dobles.\n"+
                "3. Passar torn.\n"+
                "Opció: ");       
    }
    
    public void errorOpcio() {
        System.out.println("Opció no vàlida");
    }

}
