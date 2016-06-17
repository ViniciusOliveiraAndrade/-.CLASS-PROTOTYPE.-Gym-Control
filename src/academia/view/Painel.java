package academia.view;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author vinicius
 */
public class Painel extends JPanel {
    private PanelDeInformacao pane;
    private DesktopePane desk;
   
    
    public Painel(Dimension dimension, String informacao) {
    
        desk = new DesktopePane(dimension);
        desk.setLocation(0, 0);
       
        pane = new PanelDeInformacao(informacao , dimension);
        pane.setLocation(dimension.width-(dimension.width/4), 0);
        
        add(desk);
        add(pane);
        
        setSize(dimension.width, dimension.height);
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder(""));
        setVisible(true);
    
    }

    public PanelDeInformacao getPane() {
        return pane;
    }

    public DesktopePane getDesk() {
        return desk;
    }
    
    public void addFrame(JInternalFrame frame){
        this.desk.add(frame);
    }
    
    
}
