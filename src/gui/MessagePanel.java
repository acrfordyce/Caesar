package gui;

import java.awt.*;
import javax.swing.*;

/* class MessagePanel */

/**
 * This class consists of a label centered over a JText area.
 *
 * @author Alexander Fordyce
 * @version 1.0
 */
public class MessagePanel extends JPanel {

    /** A JLabel which will be centered over the JTextArea */
    private JLabel l;
    /** A JTextArea which can accept user input or display output */
    private JTextArea t;

    /* MessagePanel */

    /** The MessagePanel constructor */
    public MessagePanel(String name) {
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gb);
        l = new JLabel(name, SwingConstants.CENTER);
        c.gridheight = 1;
        gb.setConstraints(l, c);
        add(l);
        t = new JTextArea();
        t.setColumns(18);
        t.setRows(10);
        t.setLineWrap(true);
        t.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(t);
        c.gridy = 1;
        gb.setConstraints(sp, c);
        add(sp);
    }

    public String getText() {
        return t.getText();
    }

    public void setText(String s) {
        t.setText(s);
    }

}
