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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * URLBoxController
 *
 * @author Takashi Ogura <tarchan at gmail.com>
 */
public class URLBoxController implements Initializable {
    private Logger log = Logger.getLogger(URLBoxController.class.getName());
    private StringProperty url = new SimpleStringProperty();
    @FXML
    private AnchorPane root;
    @FXML
    private TextField urlField;
    @FXML
    private Button urlCancel;
    @FXML
    private Button urlOpen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        log.log(Level.INFO, "URL={0}, ResourceBundle={1}", new Object[] {url, rb});
    }    

    public StringProperty urlProperty() {
        return url;
    }

    @FXML
    private void onUrlCancel(ActionEvent event) {
        hide();
    }

    @FXML
    private void onUrlOpen(ActionEvent event) {
        if (!urlField.getText().isEmpty()) {
            url.set(urlField.getText());
        }
        hide();
    }

    private void hide() {
        root.getScene().getWindow().hide();
    }
}
