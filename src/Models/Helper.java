/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.ShapesDAO;
import java.awt.Graphics;

/**
 *
 * @author miguel
 */
public class Helper {
    Graphics graphics;

    public Helper(Graphics graphics) {
        this.graphics = graphics;
    }
        
    public void draw(ShapesDAO shapes){
        
        for (Rectangle rectangle: shapes.getRectangles()) {
            graphics.setColor(rectangle.getColor());
            graphics.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        }
        
        for (Square  square: shapes.getSquares()) {
            graphics.setColor(square.getColor());
            graphics.fillRect(square.getX(), square.getY(), square.getSide(), square.getSide());

        }
        
        for (Circle circle: shapes.getCircles()) {
            graphics.setColor(circle.getColor());
            graphics.fillOval(circle.getX(), circle.getY(), circle.getRadius(), circle.getRadius());
        }
        
        for (Ellipse ellipse: shapes.getEllipses()) {
            graphics.setColor(ellipse.getColor());
            graphics.fillOval(ellipse.getX(), ellipse.getY(), ellipse.getWidth(), ellipse.getHeight());
        }
        
        for (Line line: shapes.getLines()) {
            graphics.setColor(line.getColor());
            graphics.drawLine(line.getX(), line.getY(), line.getX2(), line.getY2());

        }
        
    }
    
//    public void draw(ShapesDAO shapes){
//        for (Shape shape: shapes.getShapes()) {
//            graphics.setColor(shape.getColor());
//            
//            if (shape.getClass() == Rectangle.class) {
//                Rectangle rect=(Rectangle)shape;
//                graphics.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
//            }
//            if (shape.getClass() == Square.class) {
//                Square sq=(Square)shape;
//                graphics.fillRect(sq.getX(), sq.getY(), sq.getSide(), sq.getSide());
//            }
//            if (shape.getClass() == Ellipse.class) {
//                Ellipse ellipse = (Ellipse)shape;
//                graphics.fillOval(ellipse.getX(), ellipse.getY(), ellipse.getWidth(), ellipse.getHeight());
//            }
//            if (shape.getClass() == Line.class) {
//                Line line = (Line)shape;
//                graphics.drawLine(line.getX(), line.getY(), line.getX2(), line.getY2());
//            }
//            if (shape.getClass() == Circle.class) {
//                Circle circle = (Circle)shape;
//                graphics.fillOval(circle.getX(), circle.getY(), circle.getRadius(), circle.getRadius());
//            }
//        }
//    }

}
