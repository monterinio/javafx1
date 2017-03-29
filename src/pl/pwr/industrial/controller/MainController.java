package pl.pwr.industrial.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import pl.pwr.industrial.data.ConnectionData;
import pl.pwr.industrial.data.Data;
import pl.pwr.industrial.data.Strings;
import pl.pwr.industrial.utils.SaveLoadUtil;
import pl.pwr.industrial.utils.WindowUtil;

public class MainController implements Initializable {

	private Data data;
	private ConnectionData connectionData;
	private WindowUtil windowUtil;
	private SaveLoadUtil saveLoadUtil;

    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox4;
    @FXML
    private CheckBox checkBox3;
	@FXML
	private ToggleButton startButton2;
	@FXML
	private ToggleButton startButton1;
	@FXML
	private RadioButton motorA;
	@FXML
	private RadioButton motorB;
	@FXML
	private Button executeButton;
	@FXML
	private MenuItem connectionSettingsItem;
	@FXML
	private MenuItem closeItem;
	@FXML
	private MenuItem aboutItem;

	public MainController() {
		data = new Data();
		saveLoadUtil = new SaveLoadUtil();
		windowUtil = new WindowUtil();
		connectionData = saveLoadUtil.loadApplicationState();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		configureMenuItems();
		executeButton();
	}

	private void configureMenuItems() {
		connectionSettingsItem.setOnAction(x->windowUtil.loadWindowAndSendData(Strings.connectionLayoutName, Strings.connectionSettingsItemName, connectionData));
		aboutItem.setOnAction(x->windowUtil.loadWindow(Strings.aboutLayoutName,Strings.aboutItemName));
		closeItem.setOnAction(x->windowUtil.loadWindow(Strings.exitLayoutName, Strings.exitItemName));
	}

	private void executeButton() {
		executeButton.setOnAction(x-> {
			data.initializeData(startButton1, startButton2, checkBox1, checkBox2, checkBox3, checkBox4, motorA, motorB);
			windowUtil.loadWindowAndSendData(Strings.processingLayoutName, Strings.processingItemName, connectionData, data);
		});
	}

	public ConnectionData getConnectionData() {
		return connectionData;
	}

}
