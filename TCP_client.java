/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author ACER
 */
public class TCP_client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.2.0.1",2000);
            Scanner sc = new Scanner(System.in);
            int t = 0;
            
            while(true) {
                System.out.println("1. Phép cộng\n");
                System.out.println("2. Phép trừ\n");
                System.out.println("3. Phép chia\n");
                System.out.println("4. Phép nhân\n");
                System.out.println("5. Thoát\n");
                System.out.println("Lựa chọn của bạn: ");
                t = sc.nextInt();
                if(t >= 5)
                    return;
                System.out.println("Nhập a: ");
                int a = sc.nextInt();
                System.out.println("Nhập b: ");
                int b = sc.nextInt();
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeInt(t);
                dos.writeInt(a);
                dos.writeInt(b);
                DataInputStream dis = new DataInputStream(client.getInputStream());
                System.out.format("Kết quả: %d\n", dis.readInt());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } 
    }   
}
