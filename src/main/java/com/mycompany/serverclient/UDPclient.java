/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serverclient;
import java.io.IOException;
import java.net.DatagramSocket ; 
import java.net.InetAddress ; 
import java.net.DatagramPacket ;
/**
 *
 * @author bechi
 */
public class UDPclient {
public static void main(String [] args) {
    try { 
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress =InetAddress.getByName("localhost") ;
            String message="bonjour serveur " ;
            byte[] buffer= message.getBytes () ;
            DatagramPacket packet =new DatagramPacket(buffer,buffer.length,serverAddress,987);
            socket.send(packet) ;
            System.out.println("message envoyé");
            byte [] buffer1=new byte[1025];
            DatagramPacket packet1=new DatagramPacket(buffer1,buffer1.length) ;
            socket.receive(packet1) ;
            String message1= new String(packet1.getData(),0,packet1.getLength()) ;
            System.out.println("message recu"+message1) ;
            socket.close() ;
        } 
    
    } catch( IOException e )  { }
    
}    
}

