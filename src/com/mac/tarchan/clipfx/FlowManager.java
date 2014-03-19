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

import java.io.IOException;
import java.net.URL;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FlowManager
 *
 * @author tarchan
 */
public class FlowManager {
    
    private Class baseClass;

    public FlowManager(Class baseClass) {
        this.baseClass = baseClass;
    }

    public <C extends Object> C loadAndGoto(String name, final Parent owner) {
        try {
            FXMLLoader fxml = loadFXML(name);
            Parent root = fxml.getRoot();
            Object data = owner.getUserData();
            root.setUserData(data);
            Stage stage = gotoPage(root, owner);
            stage.showingProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue ov, Boolean oldValue, Boolean newValue) {
                    System.out.println("ウインドウを閉じる: " + newValue);
                    // 元のページに戻る
                    gotoPage(owner, owner);
                }
            });
//            stage.setTitle(name);
            return fxml.getController();
        } catch (IOException ex) {
            throw new RuntimeException("画面遷移できません: " + name, ex);
        }
    }

    public FXMLLoader loadFXML(String name) throws IOException {
        URL rsrc = null;
        try {
            rsrc = baseClass.getResource(name + ".fxml");
            FXMLLoader fxml = new FXMLLoader(rsrc);
            fxml.load();
            fxml.getRoot();
            fxml.getController();
            return fxml;
        } catch (IOException | RuntimeException ex) {
            throw new IOException("画面をロードできません: " + rsrc, ex);
        }
    }
    
    public void showDialog(Parent root, Parent owner) {
        Scene scene = root.getScene();
        if (scene == null) {
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(owner.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.setTitle("URLを開く");
            stage.show();
        } else {
            Stage stage = (Stage) scene.getWindow();
            stage.show();
        }
    }
    
    public Stage gotoPage(Parent root, Parent owner) {
        Stage stage = (Stage) owner.getScene().getWindow();
        if (stage == null) {
            stage = new Stage();
        }
        Scene scene = root.getScene();
        if (scene == null) {
            scene = new Scene(root);
        }
        stage.setScene(scene);
//        stage.sizeToScene();
        stage.show();
        return stage;
    }
}
