package pl.pwr.industrial.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pwr.industrial.controller.MainController;
import pl.pwr.industrial.data.ConnectionData;
import pl.pwr.industrial.data.Strings;
import pl.pwr.industrial.utils.WindowUtil;

public class IndustrialControl extends Application {
	private WindowUtil windowUtil;

	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		windowUtil = new WindowUtil();
		Parent parent = FXMLLoader.load(getClass().getResource(Strings.mainLayoutName));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.setTitle(Strings.appName);
		primaryStage.show();
		primaryStage.setOnCloseRequest(x->{
			x.consume();

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource(Strings.mainLayoutName));
				loader.load();
				MainController mainController = loader.getController();
				ConnectionData connectionData = mainController.getConnectionData();
				windowUtil.loadWindowAndSendDataTest(Strings.exitLayoutName, Strings.exitItemName, connectionData);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		});
	}

}
