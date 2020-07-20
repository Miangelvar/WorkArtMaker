/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author miguel
 */
public class LoadController {
    private JFileChooser chooser;
    
    public LoadController(FileNameExtensionFilter filter) {
        chooser = new JFileChooser();
        chooser.setFileFilter(filter);
    }
    
    public String loadFile() {
        String absolutePath = "";
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showOpenDialog(chooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
//            content = readFile(selectedFile);
            absolutePath = selectedFile.getAbsolutePath();
            System.out.println("loaded file path: " + selectedFile.getAbsolutePath());
        
        }
        return absolutePath;
    }
        
}
