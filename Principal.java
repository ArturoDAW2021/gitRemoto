package com.arturo.tareaentornos;

import java.util.ArrayList;
/**
 * Clase principal que crea gestiona los concursos asi como los envios
 * @version 1.0
 * @author Arturo Ruiz
 */
public class Principal {
    /**
    * Este es el metodo principal.
    * @param args sin usar.
    */
    public static void main(String[] args) {

        // Declaracion y creacion de los concursos
        Concurso c1 = new Concurso("Sesión 1", 2);
        Concurso c2 = new Concurso("Sesión 2", 3);
        Concurso c3 = new Concurso("Sesión 3", 3);
        
        // Creamos la lista de concursos y agrego los concursos creados anteriormente
        ArrayList<Concurso> listaConcursos = new ArrayList<Concurso>();
        listaConcursos.add(c1);
        listaConcursos.add(c2);
        listaConcursos.add(c3);
        
        // Recorro los concursos y añado los concursos y los envios
        for (Concurso c: listaConcursos) {
            // Muestro el nombre del concurso
            System.out.println("Nombre del concurso: " + c.getNombre());
            // Añado los equipos
            c.addEquipo("Equipo 1", "Equipo 2", "Equipo 3");
            // Registro los envios para todos los equipos y los problemas del concurso
            for (String e: c.getEquipos()) {
                // Recorro los problemas del concurso
                for (int i=0; i<c.getNumProblemas(); i++) {
                    c.registrarEnvio(e, i, "(1, 2)");
                }
            }
        
            // Mostramos los datos de los concursos
            System.out.println(c);
        }   
    }
}
