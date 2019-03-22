/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getapp;

import static getapp.GetApp.peticionHttpGet;

/**
 *
 * @author MXI01020253A
 */
public class MetodoUno {
    
    public void metodoUno(){
        System.out.println("METODO 1");
        System.out.println("METODO 1");
        System.out.println("METODO 1");
        
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        //String url = "https://api.mercadolibre.com/sites/MLA/search?nickname=TETE2870021";
        //String url = "https://api.nasa.gov/planetary/apod?api_key=BNnOMpUYGOuT2y8VzMDYzeuqD7ZDmMlZclTCGO7T";

        String respuesta;
        try {
            respuesta = peticionHttpGet(url);
            System.out.println("La respuesta es:\n" + respuesta);
        } catch (Exception e) {
            // Manejar excepción
            System.err.println("Error: " + e);
        }
    
    }
    
}
