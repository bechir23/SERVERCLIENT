/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serverclient;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket ;
import java.net.ServerSocket ;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bechi
 */
public class TCPserver {

    public static void main(String[] args) {
 try (ServerSocket ServerSocket = new ServerSocket(888)) {
    System.out.println("TCP Server waiting for clients on port 888...");
     try (Socket ClientSocket = ServerSocket.accept()) {
         BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
         PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);
         String message=in.readLine() ;
         System.out.println("message recu par le client"+message);
         out.println("message received by server");
     }
    ServerSocket.close() ;
    }   catch (IOException ex) {
            Logger.getLogger(TCPserver.class.getName()).log(Level.SEVERE, null, ex);
        }


}



}


