package pl.pwr.industrial.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.pwr.industrial.controller.ConnectionController;
import pl.pwr.industrial.controller.ExitController;
import pl.pwr.industrial.controller.ProcessingController;
import pl.pwr.industrial.data.ConnectionData;
import pl.pwr.industrial.data.Data;

public class WindowUtil {

	public void loadWindow(String path, String appName) {
		try {
			Stage subWindow = new Stage();
			subWindow.initModality(Modality.APPLICATION_MODAL);

			Parent parent = (Parent) FXMLLoader.load(getClass().getResource(path));
			Scene scene = new Scene(parent);

			subWindow.setScene(scene);
			subWindow.setTitle(appName);
			subWindow.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void loadWindowAndSendData(String path, String appName, ConnectionData connectionData) {
		try {
			Stage subWindow = new Stage();
			subWindow.initModality(Modality.APPLICATION_MODAL);
			FXMLLoader loader = new FXMLLoader();
			Parent parent = loader.load(getClass().getResource(path).openStream());
			ConnectionController connectionController = (ConnectionController) loader.getController();
			connectionController.getConnectionData(connectionData);

			Scene scene = new Scene(parent);

			subWindow.setScene(scene);
			subWindow.setTitle(appName);
			subWindow.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void loadWindowAndSendData(String path, String appName, ConnectionData connectionData, Data data) {
		try {
			Stage subWindow = new Stage();
			subWindow.initModality(Modality.APPLICATION_MODAL);
			FXMLLoader loader = new FXMLLoader();
			Parent parent = loader.load(getClass().getResource(path).openStream());
			ProcessingController processingController = (ProcessingController) loader.getController();
			processingController.getData(connectionData, data);
			Scene scene = new Scene(parent);
			processingController.startConnection();
			subWindow.setScene(scene);
			subWindow.setTitle(appName);
			subWindow.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void loadWindowAndSendDataTest(String path, String appName, ConnectionData connectionData) {
		try {
			Stage subWindow = new Stage();
			subWindow.initModality(Modality.APPLICATION_MODAL);
			FXMLLoader loader = new FXMLLoader();
			Parent parent = loader.load(getClass().getResource(path).openStream());
			ExitController exitController = (ExitController) loader.getController();
			exitController.getConnectionData(connectionData);

			Scene scene = new Scene(parent);

			subWindow.setScene(scene);
			subWindow.setTitle(appName);
			subWindow.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
