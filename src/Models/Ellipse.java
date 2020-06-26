/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;

/**
 *
 * @author Jeremy
 */
public class Ellipse extends Shape{
    int width, height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public Ellipse(int width, int height, int x, int y, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;        
    }
    
}
