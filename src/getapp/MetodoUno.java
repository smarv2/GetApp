/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author MXI01020253A
 */
public class MetodoUno {

    public void metodoUno() {
        System.out.println("METODO 1");
        System.out.println("METODO 1");
        System.out.println("METODO 1");

        //String url = "https://jsonplaceholder.typicode.com/todos/1";
        String url = "https://api.mercadolibre.com/sites/MLA/search?nickname=TETE2870021";
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

    public static String peticionHttpGet(String urlParaVisitar) throws Exception {
        // Esto es lo que vamos a devolver
        StringBuilder resultado = new StringBuilder();
        // Crear un objeto de tipo URL
        URL url = new URL(urlParaVisitar);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        // Búferes para leer
        BufferedReader rd;
        rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        return resultado.toString();
    }

}
