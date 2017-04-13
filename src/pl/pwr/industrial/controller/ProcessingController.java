package pl.pwr.industrial.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.pwr.industrial.data.ConnectionData;
import pl.pwr.industrial.data.Data;
import pl.pwr.industrial.utils.ConnectionUtil;

public class ProcessingController implements Initializable {

    private ConnectionData connectionData;
    private Data data;

    @FXML
    private Button exitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exitButton.setOnAction(x -> {
            ((Stage) exitButton.getScene().getWindow()).close();
        });
    }

    public void getData(ConnectionData connectionData, Data data) {
        this.connectionData = connectionData;
        this.data = data;
    }

    public void startConnection() {
        ConnectionUtil.run(connectionData, data);
    }
}
