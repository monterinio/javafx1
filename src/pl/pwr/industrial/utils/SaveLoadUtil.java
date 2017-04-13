package pl.pwr.industrial.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pl.pwr.industrial.data.ConnectionData;
import pl.pwr.industrial.data.Strings;

public final class SaveLoadUtil {

    private SaveLoadUtil() {    }

    public static void saveApplicationState(ConnectionData connectionData) {
        try (FileOutputStream fs = new FileOutputStream(Strings.FILE_NAME);
                ObjectOutputStream os = new ObjectOutputStream(fs);) {
            os.writeObject(connectionData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionData loadApplicationState() {
        ConnectionData connectionData = null;
        try (FileInputStream fis = new FileInputStream(Strings.FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            connectionData = (ConnectionData) ois.readObject();

        } catch (FileNotFoundException e) {
            connectionData = new ConnectionData();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connectionData;
    }
}
