/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.ShapeDAO;
import java.awt.Graphics;

/**
 *
 * @author Jeremy
 */
public class Helper {
    Graphics graphics;

    public Helper(Graphics graphics) {
        this.graphics = graphics;
    }
    public void draw(ShapeDAO shapes){
        for (Shape shape: shapes.getShapes()) {
            graphics.setColor(shape.getColor());
            
            if (shape.getClass()==Rectangle.class) {
                Rectangle rect=(Rectangle)shape;
                graphics.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
            }
            if (shape.getClass()==Square.class) {
                Square sq=(Square)shape;
                graphics.fillRect(sq.getX(), sq.getY(), sq.getSide(), sq.getSide());
            }
            if (shape.getClass() == Ellipse.class) {
                Ellipse ellipse = (Ellipse)shape;
            }
            if (shape.getClass() == Line.class) {
                Line line = (Line)shape;
            }
        }
    }
}
