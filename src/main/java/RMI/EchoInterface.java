/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI;
import java.rmi.Remote ;
import java.rmi.RemoteException ;
        
        
        /**
 *
 * @author bechi
 */
public interface EchoInterface extends Remote{
    String echo(String message) throws RemoteException ;
    
}
