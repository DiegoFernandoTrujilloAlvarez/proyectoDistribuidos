/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import javax.swing.JOptionPane;
import java.rmi.Naming;
import rmiinterface.RMIinterface;
/**
 *
 * @author diego
 */
public class ClientOperation {
   private static RMIinterface look_up;

    public static void main(String[] args) 
        throws MalformedURLException, RemoteException, NotBoundException {
        
        look_up = (RMIinterface) Naming.lookup("//localhost/MyServer");
        String txt = JOptionPane.showInputDialog("What is your name?");
        
        String response = look_up.helloTo(txt);
        JOptionPane.showMessageDialog(null, response);
    }
}
