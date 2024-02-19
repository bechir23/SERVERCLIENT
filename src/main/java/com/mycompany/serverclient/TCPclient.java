/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serverclient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket ;

/**
 *
 * @author bechie
 */
public class TCPclient {

    public static void main(String[] args) {
try {
    try (Socket socket = new Socket("localhost",11010)) {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
        String message ="Hello TCP" ;
        out.println(message);
        String response=in.readLine() ;
        System.out.println("Response from TCP server: " + response);
        socket.close();
    }





} 
    catch(IOException e ) 
    {}
    
    
    }
}
