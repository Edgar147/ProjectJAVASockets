package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final static int port = 7000;

    public static void main(String[] args) {

        Socket socket;
        DataInputStream userInput;
        PrintStream theOutputStream;

        try {
            Scanner scanner = new Scanner(System.in);






            socket = new Socket("localhost", port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());


            String messageSaisi="";
            String messageServeur;


            while((messageServeur = in.readLine()) != null) {
                //messageServeur = in.readLine();
                System.out.println( messageServeur);// message recu depuis serveur
                System.out.println("Ecrire un message ");

                messageSaisi = scanner.nextLine();
                out.println(messageSaisi);//client envoie


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
