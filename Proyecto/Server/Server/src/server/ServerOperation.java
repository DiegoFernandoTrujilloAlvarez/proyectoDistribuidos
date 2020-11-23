/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;
import rmiinterface.RMIinterface;

/**
 *
 * @author diego
 */
public class ServerOperation extends UnicastRemoteObject implements RMIinterface, Runnable{
    protected ServerOperation() throws RemoteException{
        super();
    }
    public String helloTo(String name) throws RemoteException{
        System.out.println(name + " conectado!");
        run();
        return "Server dice hello " + name;
    }
    
    public static void main(String[] args) {
        try{
            Naming.rebind("//localhost/MyServer",new ServerOperation());
            System.out.println("Server ready");
        } catch(Exception e){
            System.err.println("Server exception: " + e.toString());
        }
        
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++)
        {
            System.out.println("numero " + i);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
