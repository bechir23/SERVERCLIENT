/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serverclient;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;



/**
 *
 * @author bechi
 */
public class UDPserver {
    public static void main(String[] args) {
        try {
            try (DatagramSocket socket = new DatagramSocket(987)) {
                byte[] buffer = new byte[1024];
                System.out.println("Serveur UDP en attente...");
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length) ;
                socket.receive(packet) ;
                
                String message = new String(packet.getData(),0,packet.getLength()) ;
                System.out.println("message du client "+message) ;
            //    BufferedReader reader =new  BufferedReader(new InputStreamReader(System.in)) ;
              //  String message1=reader.readLine();
     String message1="here are my notes ";
               byte []  buffer1=message1.getBytes() ;
                DatagramPacket packet1=new DatagramPacket(buffer1,buffer1.length,packet.getAddress(),packet.getPort()) ;
                socket.send(packet1) ;
                socket.close();
            }
          
        } catch (IOException e) {
        }
    }
}
