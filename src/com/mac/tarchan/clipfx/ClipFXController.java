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

import java.io.File;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * ClipFXController
 * 
 * @author tarchan
 */
public class ClipFXController implements Initializable {

    @FXML
    private VBox form;
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

    private FileChooser fileChooser = new FileChooser();
    @FXML
    private TitledPane x2;
    @FXML
    private MenuItem trimMenu;
    @FXML
    private MenuItem rotateMenu;
    @FXML
    private AnchorPane canvas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<TrimSize> sizeList = sizeBox.getItems();
        sizeList.clear();
        sizeList.add(new TrimSize("艦これ", 800, 480));
        
        // ファイル名フィルタ
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG ファイル (*.png)", "*.png"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG ファイル (*.jpg)", "*.jpg", "*.jpeg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("すべてのファイル (*.*)", "*.*"));
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

    @FXML
    private void onNewFile(ActionEvent event) {
    }

    @FXML
    private void onOpenFile(ActionEvent event) {
        File file = fileChooser.showOpenDialog(form.getScene().getWindow());
        if (file == null) {
            return;
        }
        if (!file.exists()) {
            throw new RuntimeException("ファイルが見つかりません。: " + file);
        }
    }

    @FXML
    private void onCloseFile(ActionEvent event) {
    }

    @FXML
    private void onSaveFile(ActionEvent event) {
        // TODO ファイル名が確定している場合は、そのまま保存
        onSaveAsFile(event);
    }

    @FXML
    private void onSaveAsFile(ActionEvent event) {
        File file = fileChooser.showSaveDialog(form.getScene().getWindow());
        if (file == null) {
            return;
        }
        // TODO ファイルを保存
    }

    @FXML
    private void onRevertFile(ActionEvent event) {
    }

    @FXML
    private void onShowOption(ActionEvent event) {
    }

    @FXML
    private void onQuit(ActionEvent event) {
    }

    @FXML
    private void onTrimView(ActionEvent event) {
    }

    @FXML
    private void onRotateView(ActionEvent event) {
    }

    @FXML
    private void onAbout(ActionEvent event) {
    }

}
