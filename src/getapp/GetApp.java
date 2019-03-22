/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getapp;

import java.io.IOException;

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

}
