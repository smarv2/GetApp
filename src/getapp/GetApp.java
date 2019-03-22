/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 * @author MXI01020253A
 */
public class GetApp {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        MetodoUno metodoUno = new MetodoUno();
        metodoUno.metodoUno();
 
        MetodoDos.metodoDos();
       
        MetodoTres.metodoTres();
        
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
