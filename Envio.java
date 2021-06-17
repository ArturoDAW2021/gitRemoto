package com.arturo.tareaentornos;

/**
 * Clase final ya que su definicion esta completa y no se requieren sub clases.
 * Esta clase se encarga de crear envios para el concurso
 * @version 1.0
 * @author Arturo
 */

public final class Envio {
    
    
    /* Atributos de instancia de la clase, todos finales porque
    no pueden cambiar una vez establecidos en el constructor*/
    private final String nombreEquipo;
    private final int numeroProblema;
    private final String respuesta;
    
    // Constructor de envios
    /**
     * Constructor para crear envios
     * @param pNombreEquipo define el nombre del equipo a traves del constructor
     * @param pNumProb define el numero de problema a traves del constructor
     * @param pResp define la respuesta al problema a traves del constructor
     */
    public Envio(String pNombreEquipo, int pNumProb, String pResp) {
        this.nombreEquipo = pNombreEquipo;
        this.numeroProblema = pNumProb;
        this.respuesta = pResp;
    }//Cierre del constructor
    
    // Metodos Getters
    /**
     * Metodo consultor del atributo nombreEquipo
    * @return Devuelve el nombre del equipo a traves del metodo consultor
    */
    public String getNombreEquipo() {
        return nombreEquipo;
    }
    /**
     * Metodo consultor del atributo numeroProblema
    * @return Devuelve el numero de problema a traves del metodo consultor
    */
    public int getNumeroProblema() {
        return numeroProblema;
    }
    /**
     * Metodo consultor del atributo respuesta
    * @return Devuelve la respuesta al problema a traves del metodo consultor
    */
    public String getRespuesta() {
        return respuesta;
    }
    /**
     * Metodo que permite mostrar la informacion completa del envio
    * @return Devuelve una cadena de texto con los atributos del envio
    */
    @Override
    public String toString() {
        return "Envio{" + "nombreEquipo=" + nombreEquipo + ", numeroProblema=" + numeroProblema + ", respuesta=" + respuesta + '}';
    }
    
    
}
