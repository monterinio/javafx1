package pl.pwr.industrial.utils;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.pwr.industrial.controller.ConnectionDataProvider;
import pl.pwr.industrial.controller.ProcessingController;
import pl.pwr.industrial.data.ConnectionData;
import pl.pwr.industrial.data.Data;

public final class WindowUtil {
    private WindowUtil() {      };
    public static void loadWindow(String path, String appName) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent parent = loader.load(WindowUtil.class.getResource(path).openStream());
            loadWindow(parent, appName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadWindowAndSendData(String path, String appName, ConnectionData connectionData) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent parent = loader.load(WindowUtil.class.getResource(path).openStream());
            ConnectionDataProvider controller = loader.getController();
            controller.getConnectionData(connectionData);
            loadWindow(parent, appName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadWindowAndSendData(String path, String appName, ConnectionData connectionData, Data data) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent parent = loader.load(WindowUtil.class.getResource(path).openStream());
            ProcessingController processingController = (ProcessingController) loader.getController();
            processingController.getData(connectionData, data);
            processingController.startConnection();
            loadWindow(parent, appName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadWindow(Parent parent, String appName) {
        Objects.requireNonNull(parent);
        Stage subWindow = new Stage();
        subWindow.setResizable(false);
        subWindow.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(parent);
        subWindow.setScene(scene);
        subWindow.setTitle(appName);
        subWindow.show();
    }
}
