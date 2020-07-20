/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;

/**
 *
 * @author miguel
 */
public class Circle extends Shape{
    int radius;

    public int getRadius() {
        return radius;
    }
    
    public Circle(int radius, int x, int y, Color color) {
        super(x, y, color);
        this.radius = radius;
    }
    
}
