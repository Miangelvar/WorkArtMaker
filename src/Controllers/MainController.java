package Controllers;


import DAO.ShapeDAO;
import Models.Ellipse;
import Models.Line;
import Models.Rectangle;
import Models.Square;
import Views.MainWindow;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
/**
 *
 * @author Jeremy
 */
public class MainController {
    MainWindow window;
    MouseListener listener;
    ShapeDAO shapes=new ShapeDAO();
    Rectangle rectangle=new Rectangle(100,50,1,1,Color.red);
    Square square = new Square(200,100,100,Color.green);
    Ellipse ellipse;
    
    int x1,x2,y1,y2;
    

    public MainController() {
        shapes.addRectangle(rectangle);
        shapes.addSquare(square);
        window=new MainWindow(shapes);
        window.setPanel();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
    }
    
    public void initControllers() {
//        drawRectangle();
        drawEllipse();
    }    
    
    private void drawEllipse(){
        listener= new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1=e.getX();
                y1=e.getY();
                System.out.println(x1);
                System.out.println(y1);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2=e.getX();
                y2=e.getY();
                
                System.out.println(x2);
                System.out.println(y2);
                
                int width=Math.abs(x2-x1);
                int height=Math.abs(y2-y1);
                
                if (x2 < x1 && y2 < y1) {
                    ellipse = new Ellipse(width,height,x2,y2,Color.RED);
                    shapes.addEllipse(ellipse);
                    window.getPanel().repaint();
                } else if (x2 < x1 && y2 > y1){
                    ellipse = new Ellipse(width,height,x2,y1,Color.RED);
                    shapes.addEllipse(ellipse);
                    window.getPanel().repaint();
                } else if(x2 > x1 && y2 < y1) { 
                    ellipse = new Ellipse(width,height,x1,y2,Color.RED);
                    shapes.addEllipse(ellipse);
                    window.getPanel().repaint();
                } else {
                    ellipse = new Ellipse(width,height,x1,y1,Color.RED);
                    shapes.addEllipse(ellipse);
                    window.getPanel().repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
            
        };
        window.getPanel().addMouseListener(listener);
    }
        
    private void drawRectangle(){
        listener= new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1=e.getX();
                y1=e.getY();
                System.out.println(x1);
                System.out.println(y1);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2=e.getX();
                y2=e.getY();
                
                System.out.println(x2);
                System.out.println(y2);
                
                int width=Math.abs(x2-x1);
                int height=Math.abs(y2-y1);
                
                if (x2 < x1 && y2 < y1) {
                    rectangle = new Rectangle(width,height,x2,y2,Color.RED);
                    shapes.addRectangle(rectangle);
                    window.getPanel().repaint();
                } else if (x2 < x1 && y2 > y1){
                    rectangle = new Rectangle(width,height,x2,y1,Color.RED);
                    shapes.addRectangle(rectangle);
                    window.getPanel().repaint();
                } else if(x2 > x1 && y2 < y1) { 
                    rectangle = new Rectangle(width,height,x1,y2,Color.RED);
                    shapes.addRectangle(rectangle);
                    window.getPanel().repaint();
                } else {
                    rectangle = new Rectangle(width,height,x1,y1,Color.RED);
                    shapes.addRectangle(rectangle);
                    window.getPanel().repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
            
        };
        window.getPanel().addMouseListener(listener);
    }
    
    private void drawSquare() {
        listener = new MouseListener() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                
                int side = Math.abs(x2 - x1);
                
                if (x2 > x1 && y2 > y1){
                    square = new Square(side, x1, y1, Color.GREEN);
                    shapes.addSquare(square);
                    window.getPanel().repaint(); 
                } else if (x2 > x1 && y2 < y1) {
                    square = new Square(side, x1, y2, Color.GREEN);
                    shapes.addSquare(square);
                    window.getPanel().repaint();
                } else if (x2 < x1 && y2 > y1) {
                    square = new Square(side, x2, y1, Color.GREEN);
                    shapes.addSquare(square);
                    window.getPanel().repaint();
                } else {
                    square = new Square(side, x2, y2, Color.GREEN);
                    shapes.addSquare(square);
                    window.getPanel().repaint();
                }
                
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        };
        window.getPanel().addMouseListener(listener);
    }
    
    private void drawLine() {
        listener = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                
                Line line = new Line(x1, y1, x2, y2, Color.BLACK);
                shapes.addLine(line);
                window.getPanel().repaint();            
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        };        
        window.getPanel().addMouseListener(listener);
    }
}
