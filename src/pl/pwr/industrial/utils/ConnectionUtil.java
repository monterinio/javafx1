package pl.pwr.industrial.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import pl.pwr.industrial.data.ConnectionData;
import pl.pwr.industrial.data.Data;
import pl.pwr.industrial.data.Strings;

public class ConnectionUtil {
	private Socket socket;
	private OutputStream outputStream;
	private ObjectOutputStream objectOutputStream;
	private WindowUtil windowUtil;

	public void run(ConnectionData connectionData, Data data) {
		try {
			socket = new Socket(connectionData.getServerIP(),Strings.portNumber);
			outputStream = socket.getOutputStream();
			objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(data);
			closeConnection();
		} catch(Exception e) {
			windowUtil = new WindowUtil();
			windowUtil.loadWindow(Strings.exitLayoutName, Strings.exitItemName);
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			objectOutputStream.close();
			outputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
