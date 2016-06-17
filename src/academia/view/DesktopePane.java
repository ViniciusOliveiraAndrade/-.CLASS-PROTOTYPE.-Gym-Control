package academia.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;

/**
 *
 * @author vinicius
 */
public class DesktopePane extends JDesktopPane {

    public DesktopePane(Dimension d) {

        setSize(d.width - (d.width / 4), d.height);
        setBackground(new Color(238, 238, 238));
        setLocation(0, 0);
        setBorder(BorderFactory.createTitledBorder(""));
    }

}
