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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author tarchan
 */
public class TrimSize {
    public StringProperty name = new SimpleStringProperty();
    public IntegerProperty width = new SimpleIntegerProperty();
    public IntegerProperty height = new SimpleIntegerProperty();
    
    public TrimSize(int width, int height, String name) {
        this.name.set(name);
        this.width.set(width);
        this.height.set(height);
    }
    
    public String toString() {
        return String.format("%,dx%,d (%s)", width.get(), height.get(), name.get());
    }
}
