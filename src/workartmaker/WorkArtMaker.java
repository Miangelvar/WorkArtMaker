/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workartmaker;

import Controllers.MainController;
import DAO.ShapeDAO;
import Models.Rectangle;
import Models.Square;
import Views.MainWindow;
import java.awt.Color;

/**
 *
 * @author Jeremy
 */
public class WorkArtMaker {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        MainController controller = new MainController();
        
        controller.initControllers();
    }
    
}
