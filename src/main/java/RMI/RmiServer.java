/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author bechi
 */
public class RmiServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            EchoImplementation obj = new EchoImplementation();

            // Export the object to obtain a stub
            EchoInterface stub = (EchoInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Get the registry on the default port (1099)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the stub to a name in the registry
            registry.bind("hello", stub);

            System.out.println("Server is ready");
        } catch (AlreadyBoundException | RemoteException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}