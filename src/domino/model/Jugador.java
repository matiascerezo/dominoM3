package domino.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias Cerezo
 */

public  class Jugador {
    private String nom;
    public List<Fitxa> fitxes;
 
    public Jugador( String nom) {      
        this.nom = nom;
        fitxes = new ArrayList();
    } 

    public Jugador(String nom, List<Fitxa> fitxes) {
        this.nom = nom;
        this.fitxes = fitxes;
    }
    

    public String getNom() {
        return nom;
    }

    public List<Fitxa> getFitxes() {
       return fitxes;
    }  

    public void setFitxes(List<Fitxa> fitxes) {
        this.fitxes = fitxes;
    }
    
    public void colocarFitxa(Fitxa f){
        this.fitxes.remove(f);
    }

    @Override
    public String toString() {
        return "Jugador{ nom=" + nom + ", fitxes=" + fitxes + '}';
    }
    

}
