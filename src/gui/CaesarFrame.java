package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.CaesarShift;

/* class CaesarFrame */

/**
 * This class represents the CaesarCipher user interface.
 *
 * @author Alexander Fordyce
 * @version 1.0
 */
public class CaesarFrame extends JFrame {

    /** The default width of the application */
    private static final int WIDTH = 600;
    /** The default height of the application */
    private static final int HEIGHT = 350;
    /** A JComboBox which will determine the encryption key */
    private JComboBox key;
    /** Will encyrypt the plaintext and display the resulting encrypted message in the ciphertext JTextArea */
    private JButton encrypt;
    /** Will decrypt a ciphertext and display the resulting message in the plaintext JTextArea */
    private JButton decrypt;
    /** Options for selecting the encryption key */
    private enum Keys {
        A("A"), B("B"), C("C"), D("D"), E("E"), F("F"), G("G"), H("H"), I("I"), J("J"), K("K"), L("L"), M("M"), N("N"),
        O("O"), P("P"), Q("Q"), R("R"), S("S"), T("T"), U("U"), V("V"), W("W"), X("X"), Y("Y"), Z("Z");

        private final String name;

        private Keys(String s) {
            name = s;
        }
    }
    /** The encryption key */
    private Keys k = Keys.A;
    /** Handles encryption and decryption */
    private CaesarShift cs;
    /** Panels containing the plaintext and ciphertext */
    MessagePanel plaintext, ciphertext;

    /* CaesarFrame */

    /**
     * The CaesarFrame constructor
     */
    public CaesarFrame() {

        setTitle("CaesarCipher");
        setSize(WIDTH, HEIGHT);
        JMenuBar mb = new JMenuBar();
        JMenu f = new JMenu("File");
        mb.add(f);
        JMenuItem q;
        f.add(q = new JMenuItem("Quit"));
        setJMenuBar(mb);
        q.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aEvent) {
                System.exit(0);
            }
        });

        setLayout(new BorderLayout());

        JPanel center = new JPanel();
        center.setLayout(new FlowLayout());
        plaintext = new MessagePanel("Plaintext");
        center.add(plaintext);
        ciphertext = new MessagePanel("Ciphertext");
        center.add(ciphertext);
        add(center, BorderLayout.CENTER);

        JPanel north = new JPanel();
        north.add(new JLabel("Encryption Key"));
        key = new JComboBox(Keys.values());
        cs = new CaesarShift(k.name);
        key.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() != null) {
                    JComboBox jcb = (JComboBox)e.getSource();
                    k = (Keys)jcb.getSelectedItem();
                    cs.setKey(k.name);
                }
            }
        });
        north.add(key);
        add(north, BorderLayout.NORTH);

        JPanel south = new JPanel();
        encrypt = new JButton("Encrypt");
        encrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ptxt = plaintext.getText();
                ciphertext.setText(cs.encrypt(ptxt));
            }
        });
        decrypt = new JButton("Decrypt");
        decrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ctxt = ciphertext.getText();
                plaintext.setText(cs.decrypt(ctxt));
            }
        });
        south.add(encrypt);
        south.add(decrypt);
        add(south, BorderLayout.SOUTH);

    }
}
