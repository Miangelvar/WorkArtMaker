package Controllers;


import DAO.ShapesDAO;
import Models.Circle;
import Models.Ellipse;
import Models.Line;
import Models.Rectangle;
import Models.Square;
import Views.MainWindow;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author miguel
 */
public class MainController {
    MainWindow window;
    MouseListener listener;
    ActionListener buttonListener;
    
    ShapesDAO shapes;
    Rectangle rectangle;
    Square square;
    Ellipse ellipse;
    Line line;
    Circle circle;
    Color color;
    
    int x1,x2,y1,y2;
    

    public MainController() {
        shapes = new ShapesDAO();
        
//        LoadController load = new LoadController();
//        Gson gson = new Gson();
//        String path  = "/home/miguel/NetBeansProjects/WorkArtMaker/dibujitos.json";
        
//        try {
//            
//            JsonReader reader = new JsonReader(new FileReader(path));
//            ShapesDAO shapesTwo = gson.fromJson(reader, ShapesDAO.class);
//            
//            Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
//            String serialized = gson2.toJson(shapesTwo);
//            System.out.println(serialized);
//            
//            shapes = shapesTwo;
//            
////            window.getPanel().repaint();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        window=new MainWindow(shapes);
        window.setPanel();
        window.setVisible(true);
        window.setLocationRelativeTo(null);   
    
//        shapes.addRectangle(new Rectangle(40, 60, 1, 1, Color.RED));
//        shapes.addSquare(new Square(50, 100, 100, Color.BLUE));             
    }
        
    public void initControllers() {
        drawController();
        saveDrawingController();  
        loadDrawingController();
        clearDrawingController();
        loadPaintingController();
    }
    
    
    private void clearDrawingController() {
        buttonListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {                
                clearPanel();
                
            }            
        };
        window.getPanel().getClearButton().addActionListener(buttonListener);       
    }
    
    private void saveDrawingController() {
        buttonListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {                
                saveToJson();
            }
            
        };
        window.getPanel().getSaveDrawingButton().addActionListener(buttonListener);
    }
    
    private void loadPainting() {
        String path;
        LoadController load = new LoadController(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        path = load.loadFile();
//        BufferedImage image;
        Toolkit tool = Toolkit.getDefaultToolkit();
        
        Image image = tool.createImage(path);
        
        window.getPanel().setPainting(image);
        window.getPanel().repaint();
        
//        URL resource = ;
//        try {
//            image = ImageIO.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
//        ImageIcon img = new ImageIcon(path);
//        JLabel paintingLabel = new JLabel();
//        paintingLabel.setIcon(img);
//        paintingLabel.setSize(img.getIconWidth(), img.getIconHeight());        
//        Dimension size = paintingLabel.getPreferredSize();
//        paintingLabel.setBounds(1, 1, size.width, size.height);
//        window.getPanel().add(paintingLabel, new Integer(1));
//        window.getPanel().repaint();
    }
    
    private void loadPaintingController() {
        buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loadPainting();
                System.out.println("entró");
            }
            
        };
        window.getPanel().getLoadImageButton().addActionListener(buttonListener);
    }

    private void loadDrawingController() {
        buttonListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {                
                loadFromJson();
            }
            
        };
        window.getPanel().getLoadDrawingButton().addActionListener(buttonListener);
    }
    
    private void clearPanel() {
        System.out.println("Clearing drawing Panel");
        shapes = new ShapesDAO();
        window.getPanel().setShapes(shapes);
        window.getPanel().setPainting(null);
        window.getPanel().repaint();
    }
    
    
    private void saveToJson() {
        SaveController save = new SaveController();
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String serialized = gson.toJson(shapes);

//        System.out.println(serialized);
        
        save.saveFile(serialized);
        
    }
    
    private void loadFromJson() {
        LoadController load = new LoadController(new FileNameExtensionFilter("JSON", "json"));
        Gson gson = new Gson();
        String path  = load.loadFile();
        
        try {
            
            JsonReader reader = new JsonReader(new FileReader(path));
            ShapesDAO shapesTwo = gson.fromJson(reader, ShapesDAO.class);
            
            Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
            String serialized = gson2.toJson(shapesTwo);
//            System.out.println(serialized);
            
            shapes = shapesTwo;
            window.getPanel().setShapes(shapes);
            window.getPanel().repaint();
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. Try again");
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    private void colorSelection() {
        
        String selectedColor = "";        
        selectedColor = window.getPanel().getColorsComboBox().getSelectedItem().toString();
        
        switch(selectedColor) {
            case "Blue":
                color = Color.BLUE;
                break;
            case "Yellow":
                color = Color.YELLOW;
                break;
            case "Red":
                color = Color.RED;
                break;
        }
        
    }
                
        
    private void drawController() {
        listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1=e.getX();
                y1=e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2=e.getX();
                y2=e.getY();
                colorSelection();
                
                String selectedShape = "";
                selectedShape = window.getPanel().getShapesComboBox().getSelectedItem().toString();
                
                switch(selectedShape) {
                    case "Line":
                        drawLine();
                        break;
                    case "Square":
                        drawSquare();
                        break;
                    case "Rectangle":
                        drawRectangle();
                        break;
                    case "Ellipse":
                        drawEllipse();
                        break;
                    case "Circle":
                        drawCircle();
                        break;
                }                
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
    
    private void drawEllipse() {
        int width=Math.abs(x2-x1);
        int height=Math.abs(y2-y1);

        if (x2 < x1 && y2 < y1) {
            ellipse = new Ellipse(width, height, x2, y2, color);
        } else if (x2 < x1 && y2 > y1){
            ellipse = new Ellipse(width, height, x2, y1, color);
        } else if(x2 > x1 && y2 < y1) { 
            ellipse = new Ellipse(width, height, x1, y2, color);
        } else {
            ellipse = new Ellipse(width, height, x1, y1, color);
        }
        
        shapes.addEllipse(ellipse);
    }
    
    private void drawRectangle() {
        int width=Math.abs(x2-x1);
        int height=Math.abs(y2-y1);

        if (x2 < x1 && y2 < y1) {
            rectangle = new Rectangle(width,height,x2,y2, color);
        } else if (x2 < x1 && y2 > y1){
            rectangle = new Rectangle(width,height,x2,y1, color);
        } else if(x2 > x1 && y2 < y1) { 
            rectangle = new Rectangle(width,height,x1,y2, color);
        } else {
            rectangle = new Rectangle(width,height,x1,y1, color);
        }
        
        shapes.addRectangle(rectangle);
    }
    
    private void drawSquare() {
        int side = Math.abs(x2 - x1);

        if (x2 > x1 && y2 > y1){
            square = new Square(side, x1, y1, color);            
        } else if (x2 > x1 && y2 < y1) {
            square = new Square(side, x1, y2, color);
        } else if (x2 < x1 && y2 > y1) {
            square = new Square(side, x2, y1, color);
        } else {
            square = new Square(side, x2, y2, color);
        }
        shapes.addSquare(square);
    }
    
    private void drawLine() {
        line = new Line(x1, y1, x2, y2, color);
        shapes.addLine(line);
    }
    
    private void drawCircle() {
        int squaredX = (int) Math.pow(Math.abs(x2 - x1), 2);        
        int squaredY = (int) Math.pow(Math.abs(y2 - y1), 2);        
        int radius = (int) Math.sqrt(squaredX + squaredY);
        int diameter = 2 * radius;
        
        circle = new Circle(diameter, x1 - radius, y1 - radius, color);
        shapes.addCircle(circle);
    }
}

