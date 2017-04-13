package pl.pwr.industrial.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import pl.pwr.industrial.data.ConnectionData;
import pl.pwr.industrial.data.Data;
import pl.pwr.industrial.data.Strings;

public class ConnectionUtil {
    private ConnectionUtil() {  }
    public static void run(ConnectionData connectionData, Data data) {
        try (
            Socket socket = new Socket(connectionData.getServerIP(), Strings.PORT_NUMBER);
            OutputStream outputStream = socket.getOutputStream();
                ) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
