/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workartmaker;

import Controllers.MainController;

/**
 *
 * @author miguel
 */
public class WorkArtMaker {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        MainController controller = new MainController();
//        ShapesDAO shapes = new ShapesDAO();
//        Rectangle r = new Rectangle(300, 400, 1, 1, Color.RED);
//        Square sq = new Square(200, 300, 500, Color.BLUE);
//        shapes.addRectangle(r);
//        shapes.addSquare(sq);
        
//        Gson json = new GsonBuilder().setPrettyPrinting().create();
//        Gson json = new Gson();  
//        String serialized = json.toJson(shapes);
//        System.out.println(serialized);       
//        
//        
//        ShapesDAO shapesTwo = json.fromJson(serialized, ShapesDAO.class);
//        int i = 0;
//        
//        for (Shape shape: shapesTwo.getRectangles()) {
//            System.out.println(shape.getClass());
//            System.out.println();
//        } 
        controller.initControllers();
    }
    
}
