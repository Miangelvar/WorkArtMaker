/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Ellipse;
import Models.Line;
import Models.Rectangle;
import Models.Shape;
import Models.Square;
import java.util.ArrayList;

/**
 *
 * @author Jeremy
 */
public class ShapeDAO {
    ArrayList <Shape> shapes;

    public ShapeDAO() {
        shapes= new ArrayList();
    }
    
    public void addRectangle(Rectangle r){
        shapes.add(r);
    }
    public void addSquare(Square s){
        shapes.add(s);
    }
    
    public void addLine(Line line){
        shapes.add(line);
    }
    
    public void addEllipse(Ellipse ellipse){
        shapes.add(ellipse);
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
    
    
}
