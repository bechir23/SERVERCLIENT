/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

/**
 *
 * @author bechi
 */
public class EchoImplementation implements EchoInterface{
    @Override
    public String echo(String message) {
      System.out.println("Received message from client: " + message);
        return "Server says: " + message;} 
}
