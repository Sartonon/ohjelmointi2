import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * @author Santeri Rusila
 * @version 1.2.2012
 */
public class SyntymavuosiGUI extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JLabel lblNewLabel = new JLabel("Kerron sinulle paljonko t\u00E4yt\u00E4t t\u00E4n\u00E4 vuonna!");
    private final JLabel lblNewLabel_1 = new JLabel("Syntym\u00E4vuotesi");
    private final JTextField textField = new JTextField();
    private final JLabel lblNewLabel_2 = new JLabel("T\u00E4yt\u00E4t t\u00E4n\u00E4 vuonna");
    private final JTextField textField_1 = new JTextField();
    private final JLabel lblVuotta = new JLabel("vuotta");

    /**
     * Launch the application.
     * @param args 
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SyntymavuosiGUI frame = new SyntymavuosiGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SyntymavuosiGUI() {
        textField_1.setColumns(10);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent arg0) {
                
                
            }
        });
        textField.setColumns(10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 353, 226);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FormLayout(new ColumnSpec[] {
                FormFactory.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"),},
            new RowSpec[] {
                FormFactory.RELATED_GAP_ROWSPEC,
                FormFactory.DEFAULT_ROWSPEC,
                FormFactory.RELATED_GAP_ROWSPEC,
                FormFactory.DEFAULT_ROWSPEC,
                FormFactory.RELATED_GAP_ROWSPEC,
                FormFactory.DEFAULT_ROWSPEC,
                FormFactory.RELATED_GAP_ROWSPEC,
                FormFactory.DEFAULT_ROWSPEC,
                FormFactory.RELATED_GAP_ROWSPEC,
                FormFactory.DEFAULT_ROWSPEC,
                FormFactory.RELATED_GAP_ROWSPEC,
                FormFactory.DEFAULT_ROWSPEC,}));
        
        contentPane.add(lblNewLabel, "2, 2");
        
        contentPane.add(lblNewLabel_1, "2, 4");
        
        contentPane.add(textField, "2, 6, left, default");
        
        contentPane.add(lblNewLabel_2, "2, 8");
        
        contentPane.add(textField_1, "2, 10, left, default");
        
        contentPane.add(lblVuotta, "2, 12");
    }
}
