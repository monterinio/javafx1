package pl.pwr.industrial.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.pwr.industrial.data.ConnectionData;
import pl.pwr.industrial.utils.SaveLoadUtil;

public class ExitController implements Initializable, ConnectionDataProvider {

	private SaveLoadUtil saveLoadUtil;
	private ConnectionData connectionData;

	@FXML
    private Button yesButton;

    @FXML
    private Button noButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		saveLoadUtil = new SaveLoadUtil();
		yesButton.setOnAction(x->{
			saveLoadUtil.saveApplicationState(getConnectionData());
			Platform.exit();
		});
		noButton.setOnAction(x-> ((Stage) noButton.getScene().getWindow()).close()); //najpierw pobiera sie stage z kontekstu noButton a potem zamyka to okno
	}

	public void getConnectionData(ConnectionData connectionData) {
		setConnectionData(connectionData);
	}

	public ConnectionData getConnectionData() {
		return connectionData;
	}

	public void setConnectionData(ConnectionData connectionData) {
		this.connectionData = connectionData;
	}
}
