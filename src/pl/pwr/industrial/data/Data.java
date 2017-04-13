package pl.pwr.industrial.data;

import java.io.Serializable;

import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;

public class Data implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private boolean startButton1;
    private boolean startButton2;
    private boolean checkBox1;
    private boolean checkBox2;
    private boolean checkBox3;
    private boolean checkBox4;
    private boolean motorA;
    private boolean motorB;

    public boolean isStartButton1() {
        return startButton1;
    }

    public void setStartButton1(boolean startButton1) {
        this.startButton1 = startButton1;
    }

    public boolean isStartButton2() {
        return startButton2;
    }

    public void setStartButton2(boolean startButton2) {
        this.startButton2 = startButton2;
    }

    public boolean isCheckBox1() {
        return checkBox1;
    }

    public void setCheckBox1(boolean checkBox1) {
        this.checkBox1 = checkBox1;
    }

    public boolean isCheckBox2() {
        return checkBox2;
    }

    public void setCheckBox2(boolean checkBox2) {
        this.checkBox2 = checkBox2;
    }

    public boolean isCheckBox3() {
        return checkBox3;
    }

    public void setCheckBox3(boolean checkBox3) {
        this.checkBox3 = checkBox3;
    }

    public boolean isCheckBox4() {
        return checkBox4;
    }

    public void setCheckBox4(boolean checkBox4) {
        this.checkBox4 = checkBox4;
    }

    public boolean isMotorA() {
        return motorA;
    }

    public void setMotorA(boolean motorA) {
        this.motorA = motorA;
    }

    public boolean isMotorB() {
        return motorB;
    }

    public void setMotorB(boolean motorB) {
        this.motorB = motorB;
    }

    public void initializeData(ToggleButton startButton1, ToggleButton startButton2, CheckBox checkBox1,
            CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, RadioButton motorA, RadioButton motorB) {
        //Poprawi w przyszlosci
        setStartButton1(startButton1.isSelected());
        setStartButton2(startButton2.isSelected());
        setCheckBox1(checkBox1.isSelected());
        setCheckBox2(checkBox2.isSelected());
        setCheckBox3(checkBox3.isSelected());
        setCheckBox4(checkBox4.isSelected());
        setMotorA(motorA.isSelected());
        setMotorB(motorB.isSelected());
    }
}
