/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author miguel
 */
public class SaveController {
    
    public void saveFile(String content){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showSaveDialog(chooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = chooser.getSelectedFile();
            
//            File fileCreated = createFile(fileToSave.getName());
            File fileCreated = createFile(fileToSave.getAbsolutePath());
            writeToFile(fileCreated, content);
            
            System.out.println("Expected file Path: " + fileToSave.getAbsolutePath());
        
        }
    }
    
    private File createFile(String filename){
        File file = new File(filename);
        try {
            
            if (file.createNewFile()) {
              System.out.println("File created: " + file.getName());
                System.out.println("Path: " + file.getAbsolutePath());
            } else {
              System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return file;
    }
    
    private void writeToFile(File file, String content) {
    try {
      FileWriter myWriter = new FileWriter(file);
      myWriter.write(content);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
    
}
