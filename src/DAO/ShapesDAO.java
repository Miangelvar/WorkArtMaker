/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Circle;
import Models.Ellipse;
import Models.Line;
import Models.Rectangle;
import Models.Shape;
import Models.Square;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class ShapesDAO {
    
    @SerializedName("rectangles")
    ArrayList <Rectangle> rectangles;
    @SerializedName("squares")
    ArrayList <Square> squares;
    @SerializedName("circles")
    ArrayList <Circle> circles;
    @SerializedName("ellipses")
    ArrayList <Ellipse> ellipses;
    @SerializedName("lines")
    ArrayList <Line> lines;   

    public ShapesDAO() {
        rectangles = new ArrayList();
        squares = new ArrayList();
        lines = new ArrayList();
        ellipses = new ArrayList();
        circles = new ArrayList();
    }
    
    public void addRectangle(Rectangle r){
        rectangles.add(r);
    }
    public void addSquare(Square s){
        squares.add(s);
    }
    
    public void addLine(Line line){
        lines.add(line);
    }
    
    public void addEllipse(Ellipse ellipse){
        ellipses.add(ellipse);
    }
    
    public void addCircle(Circle circle) {
        circles.add(circle);
    }
        
    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    public ArrayList<Ellipse> getEllipses() {
        return ellipses;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
    
}
