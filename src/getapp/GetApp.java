/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author MXI01020253A
 */
public class GetApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("LINEA 1");
        System.out.println("LINEA 1");
        System.out.println("LINEA 1");
        
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

        metodoDos();
        try {
            metodoTres();
        } catch (IOException ex) {
            System.err.println("Error: " + ex);
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
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
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

    private static void metodoDos() {
        try {
            System.out.println("LINEA 2");
            System.out.println("LINEA 2");
            System.out.println("LINEA 2");
            
            String url = "https://api.mercadolibre.com/sites/MLA/search?nickname=TETE2870021";
            //String url = "https://jsonplaceholder.typicode.com/todos/1";

            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            conn.setRequestMethod("GET");

            /*String userpass = "user" + ":" + "pass";
            String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes("UTF-8"));
            conn.setRequestProperty("Authorization", basicAuth);*/
            String data = "{\"format\":\"json\",\"pattern\":\"#\"}";
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(data);
            out.close();

            new InputStreamReader(conn.getInputStream());

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    private static void metodoTres() throws IOException {
        System.out.println("LINEA 3");
        System.out.println("LINEA 3");
        System.out.println("LINEA 3");
        //String endpoint = "https://api.mercadolibre.com/sites/MLA/search?nickname=TETE2870021";
        String endpoint = "https://jsonplaceholder.typicode.com/todos/1";

        String url = endpoint;

        System.out.println(url);
        HttpClientBuilder hcBuilder = HttpClients.custom();
        HttpClient client = hcBuilder.build();
        HttpGet request = new HttpGet(url);
        //Setting header parameters
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Accept", "application/json");

        //Executing the call
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException ex) {
            Logger.getLogger(GetApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\nSending 'Get' to " + url);
        System.out.println("HTTP Response: " + response.getStatusLine().getStatusCode());
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        //Reading the response
        StringBuilder result = new StringBuilder();
        String line = "";
        
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        
        System.out.println(result.toString());
    }


}
