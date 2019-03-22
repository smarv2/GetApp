/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getapp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author MXI01020253A
 */
public class MetodoDos {
    
    static void metodoDos() {
     try {
            System.out.println("METODO 2");
            System.out.println("METODO 2");
            System.out.println("METODO 2");
            
            //String url = "https://api.mercadolibre.com/sites/MLA/search?nickname=TETE2870021";
            String url = "https://jsonplaceholder.typicode.com/todos/1";

            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            conn.setRequestMethod("GET");

            /*String userpass = "user" + ":" + "pass";
            String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes("UTF-8"));
            conn.setRequestProperty("Authorization", basicAuth);*/
            String data = "{\"format\":\"json\",\"pattern\":\"#\"}";
         try (OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream())) {
             out.write(data);
         }

            new InputStreamReader(conn.getInputStream());

        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }
}
