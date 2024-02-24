/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bechi
 */
   
    public class RmiClient {
    public static void main(String[] args) {
        try {
            // Get the registry on the specified host and port
            Registry registry = LocateRegistry.getRegistry("192.168.1.17", 1099);

            // Look up the remote object by the name "hello"
            EchoInterface stub = (EchoInterface) registry.lookup("hello");

            // Invoke the remote method
            System.out.println(stub.echo("bechir"));
            System.out.println("Method invoked by Client");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}