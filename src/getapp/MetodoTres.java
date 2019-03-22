/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class MetodoTres {

 static void metodoTres() throws IOException {
        System.out.println("METODO 3");
        System.out.println("METODO 3");
        System.out.println("METODO 3");
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
