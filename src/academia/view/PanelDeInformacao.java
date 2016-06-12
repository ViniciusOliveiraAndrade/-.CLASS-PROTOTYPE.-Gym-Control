package academia.view;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vinicius
 */
public class PanelDeInformacao extends JPanel {

    private JLabel informacaoLabel;

    public PanelDeInformacao(String informacao, Dimension dimension) {
        informacaoLabel = new JLabel(informacao);
        informacaoLabel.setBounds(10, 20,(dimension.width/4), 10);
        add(informacaoLabel);
        
        setBounds((dimension.width/4), (dimension.height/5),dimension.width-(dimension.width/4), 0);
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Dados Pessoais"));
        setVisible(true);

    }

}
