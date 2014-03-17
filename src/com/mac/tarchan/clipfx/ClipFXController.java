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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * ClipFXController
 * 
 * @author tarchan
 */
public class ClipFXController implements Initializable {

    private Clipboard clipboard = Clipboard.getSystemClipboard();
    private FileChooser fileChooser = new FileChooser();
    private AnchorPane urlBox;
    private URLBoxController urlBoxController;
    @FXML
    private VBox form;
    @FXML
    private MenuItem newMenu;
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
    private ComboBox<TrimSize> sizeBox;
    @FXML
    private CheckBox ratioBox;
    @FXML
    private Button switchButton;
    @FXML
    private Button trimButton;
    @FXML
    private MenuItem trimMenu;
    @FXML
    private MenuItem rotateMenu;
    @FXML
    private ImageView canvas;
    @FXML
    private TitledPane trimPanel;
    @FXML
    private TitledPane rotatePanel;
    @FXML
    private ScrollPane scrollPanel;
    @FXML
    private Slider rotateSlider;
    @FXML
    private TextField rotateField;
    @FXML
    private Insets x1;
    @FXML
    private Group group;
    @FXML
    private MenuItem openFileMenu;
    @FXML
    private MenuItem openUrlMenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<TrimSize> sizeList = sizeBox.getItems();
        sizeList.clear();
        sizeList.add(new TrimSize(800, 480, "艦これ"));
        sizeList.add(new TrimSize(500, 500, "正方形"));
        
        // ファイル名フィルタ
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG ファイル (*.png)", "*.png"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG ファイル (*.jpg;*.jpeg)", "*.jpg", "*.jpeg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("すべてのファイル (*.*)", "*.*"));
        
        // 回転
        rotateField.textProperty().bind(rotateSlider.valueProperty().asString());
        canvas.rotateProperty().bind(rotateSlider.valueProperty());
        
        // URLダイアログ
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("URLBox.fxml"));
            fxml.load();
            urlBox = fxml.getRoot();
            urlBoxController = fxml.getController();
            urlBoxController.urlProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                    setImageURL(newValue);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(ClipFXController.class.getName()).log(Level.SEVERE, "ダイアログをロードできません。: URLBox.fxml", ex);
        }
    }

    @FXML
    private void onSize(ActionEvent event) {
        TrimSize item = sizeBox.getSelectionModel().getSelectedItem();
        Rectangle rect = new Rectangle(item.width.get(), item.height.get());
        rect.setStrokeWidth(5.0);
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.TRANSPARENT);
        group.getChildren().add(rect);
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
        Image image = clipboard.getImage();
        setImage(image);
    }

    private void setImage(Image image) {
        if (image == null) {
            return;
        }
        canvas.setImage(image);
        canvas.setFitWidth(image.getWidth());
        canvas.setFitHeight(image.getHeight());
        scrollPanel.requestLayout();
    }

    private void setImageURL(String url) {
        Image image = new Image(url);
        setImage(image);
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
        try {
            setImageURL(file.toURI().toURL().toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClipFXController.class.getName()).log(Level.SEVERE, "イメージを開けません。: " + file, ex);
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
        Platform.exit();
    }

    @FXML
    private void onTrimView(ActionEvent event) {
        trimPanel.expandedProperty().set(true);
    }

    @FXML
    private void onRotateView(ActionEvent event) {
        rotatePanel.expandedProperty().set(true);
    }

    @FXML
    private void onAbout(ActionEvent event) {
    }

    @FXML
    private void onOpenUrl(ActionEvent event) {
        Scene scene = urlBox.getScene();
        if (scene == null) {
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(form.getScene().getWindow());
            stage.setScene(new Scene(urlBox));
            stage.setTitle("URLを開く");
            stage.show();
        } else {
            Stage stage = (Stage) scene.getWindow();
            stage.show();
        }
    }

    @FXML
    private void onCopy(ActionEvent event) {
        Image image = canvas.getImage();
        if (image == null) {
            return;
        }
        ClipboardContent content = new ClipboardContent();
        content.putImage(image);
        clipboard.setContent(content);
    }

    @FXML
    private void onPaste(ActionEvent event) {
        Image image = clipboard.getImage();
        setImage(image);
    }

}
