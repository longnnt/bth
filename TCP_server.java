/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
class calculator implements Calculator_itf {

    @Override
    public int plus(int a, int b) {
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }

    @Override
    public int divide(int a, int b) {
        return a/b;
    }

    @Override
    public int muliply(int a, int b) {
        return a*b;
    }
    
}
public class TCP_server{
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2000);
            System.out.println("server is running");
            while(true) {
                Socket conn = server.accept();   
                DataInputStream dis = new DataInputStream(conn.getInputStream());
                int choice = dis.readInt();
                int a = dis.readInt();
                int b = dis.readInt();
                System.out.format("%d %d %d",choice, a, b);
                calculator cal = new calculator();
                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                if(choice == 1) {
                    dos.writeInt(cal.plus(a,b));
                } 
                if(choice == 2) {
                    dos.writeInt(cal.minus(a, b));
                }
                if(choice == 3) {
                    dos.writeInt(cal.divide(a, b));
                }
                if(choice == 4) {
                    dos.writeInt(cal.muliply(a, b));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
