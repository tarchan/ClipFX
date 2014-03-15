/*
 * Copyright 2014 Takashi Ogura <tarchan at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;

/**
 * ClipFXController
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
