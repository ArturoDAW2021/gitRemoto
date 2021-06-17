
package com.arturo.tareaentornos;

import java.util.ArrayList;
/**
 * Clase encarga de crear y gestionar concursos
 * @version 1.0
 * @author Arturo Ruiz
 */
public class Concurso {
    
    // Constante que nos indica el numero de problemas por defecto
    private static final int NUM_PROBLEMAS_DEFAULT = 5;
    
    // Atributos de la clase concurso
    private String nombre;//nombre del concurso
    private final int numProblemas;//numero de problemas del concurso
    private ArrayList<String> equipos;//lista de equipos que participan
    private ArrayList<Envio> envios;//lista de envios
    
    // Constructores
    /**
     * Constructor para crear concursos
     * @param pNombre define el nombre del concurso a traves del constructor
     * @param pNumProblemas define numero de problemas a traves del constructor
     */
    public Concurso(String pNombre, int pNumProblemas) {
        this.nombre = pNombre;
        this.numProblemas = pNumProblemas;
        this.equipos = new ArrayList<String>();
        this.envios = new ArrayList<Envio>();
    }//cierre del constructor
    /**
     * Constructor alternativo para crear concursos que solo recibe el nombre
     * @param pNombre define el nombre del concurso a traves del constructor
     */
    public Concurso(String pNombre) {
        this.nombre = pNombre;
        this.numProblemas = Concurso.NUM_PROBLEMAS_DEFAULT;
        this.equipos = new ArrayList<String>();
        this.envios = new ArrayList<Envio>();
    }
    
    // Metodos Getters y setters
    /**
    * Metodo consultor del atributo nombre
    * @return Devuelve el nombre del concurso a traves del metodo consultor
    */
    public String getNombre() {
        return nombre;
    }
    /**
    * Metodo modificador del atributo nombre
    * @param nombre modifica el nombre del concurso a traves del metodo modificador
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
    * Metodo consultor del atributo equipos
    * @return Devuelve los equipos del concurso a traves del metodo consultor
    */
    public ArrayList<String> getEquipos() {
        return equipos;
    }
    /**
    * Metodo modificador del la lista equipos
    * @param equipos modifica los equipos a traves del metodo modificador
    */
    public void setEquipos(ArrayList<String> equipos) {
        this.equipos = equipos;
    }
    /**
    * Metodo consultor del atributo envios
    * @return Devuelve los envios del concurso a traves del metodo consultor
    */
    public ArrayList<Envio> getEnvios() {
        return envios;
    }
    /**
    * Metodo modificador del la lista de envios
    * @param envios modifica los envios a traves del metodo modificador
    */
    public void setEnvios(ArrayList<Envio> envios) {
        this.envios = envios;
    }
    /**
    * Metodo consultor del atributo numProblemas
    * @return Devuelve el numero de problemas a traves del metodo consultor
    */
    public int getNumProblemas() {
        return numProblemas;
    }
    
     // Métodos de instancia
    /**
    * Metodo para obtener la propiedad calculada numero de equipos
    * @return Devuelve el numero de equipos participantes
    */
    public int numEquipos() {
        return this.equipos.size();
    }
    /**
    * Metodo para añadir uno o varios equipos a un concurso
    * @param lista es una secuencia de nombres de equipos para registrarlos en el concurso
    */
    public void addEquipo(String... lista) {
        /*Hay que comprobar si los nombres que me han pasado estan ya en la lista
        de equipos asi que creare un metodo privado para comprobar
        si el equipo esta en la lista de equipos del concurso*/
        for (String s: lista) {
            if (!this.contieneEquipo(s)) {//metodo para hacer la comprobacion
                this.equipos.add(s);
            }
        }
    }
    /**
    * Metodo para eliminar un equipo que ya esta en la lista de equipos
    * @param equipo se pasa como parametro el nombre de un equipo
    * @return devuelve verdadero si ha eliminado al equipo sino false
    */
    public boolean delEquipo(String equipo) {
        //Comprobamos si el equipo esta en la lista de equipos participantes
        if (this.contieneEquipo(equipo)) {
            //Eliminamos los envios del equipo
            for (Envio e: envios) {
                if (e.getNombreEquipo().equalsIgnoreCase(equipo)) {
                    this.envios.remove(e);
                }
            }
            //Luego eliminamos el equipo
            this.equipos.remove(equipo);
            return true;
        } else {//Si el equipo no esta en la lista devolvemos false directamente
            return false;
        }
    }
    /**
    * Metodo para registrar el envio de un equipo
    * @param pNomEquipo define el nombre del equipo que hace el envio
    * @param pNumProb define el numero de problema que contesta el equipo
    * @param pRespuesta define la respuesta del equipo a dicho problema
    * @return devuelve el envio si lo ha registrado sino devuelve null
    */
    public Envio registrarEnvio(String pNomEquipo, int pNumProb, String pRespuesta) {
        //Condiciones para que el envio se registre
        if ((this.contieneEquipo(pNomEquipo)) && (pNumProb>=0 && pNumProb<this.numProblemas) && (!pRespuesta.equals("") || pRespuesta==null)) {
            Envio e = new Envio(pNomEquipo, pNumProb, pRespuesta);
            this.envios.add(e);
            return e;
        } else {
            // Si no se cumplen los requisitos devuelvo null indicando que no se ha creado el envío
            return null;
        }
    }
    /**
     * Metodo que permite mostrar la informacion completa del concurso
    * @return Devuelve una cadena de texto con los atributos del concurso
    */
    @Override
    public String toString() {
        return "Concurso{" + "nombre=" + nombre + ", numProblemas=" + numProblemas + ", equipos=" + equipos + ", envios=" + envios + '}';
    }
    
    
    
            
    
    /**
    * Metodo privado que comprueba si un nombre de equipo ya esta en la lista
    * @param equipo se pasa como parametro el nombre de un equipo
    * @return Devuelve true si encuentra el nombre de equipo, si no false
    */
    private boolean contieneEquipo(String equipo) {
        //Recorre la lista de equipos y comprueba
        for (String s: this.equipos) {
            if (s.equalsIgnoreCase(equipo)) {
                //Si encuentra al equipo devuelve true
                return true;
            }
        }
        //Si no encuentra al equipo devuelve false
        return false;
    }
    
}
