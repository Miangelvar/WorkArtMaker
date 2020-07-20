/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.ShapesDAO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 *
 * @author miguel
 */
public class ContainerPanel extends JFrame{
    private MainPanel mainPanel;
    private ToolPanel toolPanel;
    ShapesDAO shapes;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public ToolPanel getToolPanel() {
        return toolPanel;
    }
    
    public ContainerPanel(ShapesDAO shapes) {
        this.shapes = shapes;
        this.toolPanel = new ToolPanel();
        this.mainPanel = new MainPanel(shapes);
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        super.add(toolPanel);
        super.add(mainPanel);
    }
}
