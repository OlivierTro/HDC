<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author ANNELAURE
 */
public class Adresse {
    private String ville;
    private int codePostal;
    private String voie;
    private int numero;
    
    public Adresse(String ville, int codePostal, String voie, int numero){
        this.ville=ville;
        this.codePostal=codePostal;
        this.voie=voie;
        this.numero=numero;
    }
    
    public String toString(){
        return this.getNumero()+" "+this.getVoie() +"  \n" + this.getCodePostal()+" "+ this.getVille();
    }
    
    public String getVille(){
        return ville;
    }
    
    public int getCodePostal(){
        return codePostal;
    }
    
    public String getVoie(){
        return voie;
    }
    
    public int getNumero(){
        return numero;
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author ANNELAURE
 */
public class Adresse {
    private String ville;
    private int codePostal;
    private String voie;
    private int numero;
    
    public Adresse(String ville, int codePostal, String voie, int numero){
        this.ville=ville;
        this.codePostal=codePostal;
        this.voie=voie;
        this.numero=numero;
    }
    
    public String toString(){
        return this.getNumero()+" "+this.getVoie() +"  \n" + this.getCodePostal()+" "+ this.getVille();
    }
    
    public String getVille(){
        return ville;
    }
    
    public int getCodePostal(){
        return codePostal;
    }
    
    public String getVoie(){
        return voie;
    }
    
    public int getNumero(){
        return numero;
    }
    
}
>>>>>>> 18c44281185988e0f340a093422516ed4d5c089c
