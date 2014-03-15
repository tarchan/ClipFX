/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.tarchan.clipfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TitledPane;

/**
 *
 * @author tarchan
 */
public class ClipFXController implements Initializable {

    @FXML
    private MenuItem newMenu;
    @FXML
    private MenuItem openMenu;
    @FXML
    private Menu recentMenu;
    @FXML
    private MenuItem closeMenu;
    @FXML
    private MenuItem saveMenu;
    @FXML
    private MenuItem saveAsMenu;
    @FXML
    private MenuItem revertMenu;
    @FXML
    private MenuItem optionMenu;
    @FXML
    private MenuItem quitMenu;
    @FXML
    private MenuItem aboutMenu;
    @FXML
    private TitledPane x1;
    @FXML
    private ComboBox<TrimSize> sizeBox;
    @FXML
    private CheckBox ratioBox;
    @FXML
    private Button switchButton;
    @FXML
    private Button trimButton;

    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<TrimSize> sizeList = sizeBox.getItems();
        sizeList.clear();
        sizeList.add(new TrimSize("艦これ", 800, 480));
    }

    @FXML
    private void onSize(ActionEvent event) {
    }

    @FXML
    private void onRatio(ActionEvent event) {
    }

    @FXML
    private void onSwitch(ActionEvent event) {
    }

    @FXML
    private void onTrim(ActionEvent event) {
    }

}
