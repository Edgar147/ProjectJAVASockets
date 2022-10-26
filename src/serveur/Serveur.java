package serveur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Serveur {

    public static void main(String[] args){
        String mot0="bonjour";
        char[] mot = mot0.toCharArray();

        int longeur=mot0.length();
        String masque= IntStream.range(0, longeur).mapToObj(i -> "*").collect(Collectors.joining(""));
        System.out.println("The word is "+mot);
        StringBuffer buf = new StringBuffer(masque);
        Boolean premierSaisie=false;

        try{

            ServerSocket ss = new ServerSocket(7000);
            Socket socketClient = ss.accept();//C'est ici qu'il va attendre la connection, ce qu'on va ecrire d'ici jusqu'au while, le client va voir sans toucher au clavier...
            BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            PrintStream out = new PrintStream(socketClient.getOutputStream());
            out.println("Pour jouer dans le mode normal appuyer sur 1");

            String message = "";

            while ((message = in.readLine()) != null) {



                System.out.println("Connexion avec : " + socketClient.getInetAddress());

                // InputStream in = socketClient.getInputStream();
                // OutputStream out = socketClient.getOutputStream();



               // message = in.readLine(); //message qu'on reçoit depuis client..



            if (premierSaisie) {
                char c = message.charAt(0);
                for (int i = 0; i < longeur; i++) {
                    if (c == mot[i]) {
                        buf.setCharAt(i, c);
                    }
                }
                out.println("Devine "+buf);

            }
            else{
                out.println("Devine "+buf);
            }
                premierSaisie=true;


                //System.out.println("La lettre envoye par client "+c);

                //System.out.println(message);
                String message2= message+" SERVER";
               // System.out.println("Serveur a recu "+message);
                //System.out.println("Devine "+masque);



/*                System.out.println("Serveur reçoit: " + message);
                out.println("Serveur envoie:"+message2);*/



                //socketClient.close();
            }
//            Socket s = ss.accept();
//
//            System.out.println("Client connected");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("SERVER!!!!!!!!!!!!!!!!!!!");
    }

}
