package be.uantwerpen;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Reinout on 1/03/2017.
 */
public class TcpSender {
    public static void main(String args[])throws IOException{
        Socket socket =  new Socket("localhost",6789);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeBytes(new String("03#%PianoMan#%Billy Joel#%The Piano Man#%1987"));
        socket.close();
    }
}
