/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public TrimSize(String name, int width, int height) {
        this.name.set(name);
        this.width.set(width);
        this.height.set(height);
    }
    
    public String toString() {
        return String.format("%,dx%,d (%s)", width.get(), height.get(), name.get());
    }
}
