package view;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author vinicius
 */
public class TelaInstrutor extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TelaInstrutor() {

        setTitle("Academia: Instrutor");
        setSize(500, 500);
        setVisible(true);
        setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/res/Icon.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new FlowLayout());

    }
}
