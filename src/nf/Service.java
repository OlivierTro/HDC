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
public enum Service {
    MedicoTechnique("Medico-Technique"),
    Clinique("Clinique"),
    Anesthesie("Anesthésie"),
    Radiologie("Radiologie");
    
    private String service;
    
    private Service(String service){
        this.service=service;
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
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
public abstract class Service {

    private PraticienHospitalier chefDeService;

    private String nomService;
    private String typeService;

    public Service(String nomService, String typeService) {
        this.nomService = nomService;
        this.typeService = typeService;
    }

    public String getNom() {
        return nomService;
    }
    
    public String getType(){
        return typeService;
    }

    public boolean equals(Service s) {
        boolean b = false;
        if (this.nomService.equals(s.getNom())) {
            b = true;
        }
        return b;
    }

}
>>>>>>> 18c44281185988e0f340a093422516ed4d5c089c
