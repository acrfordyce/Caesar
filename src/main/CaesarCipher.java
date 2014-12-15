package main;

import gui.CaesarFrame;

import javax.swing.*;

/* class CaesarCipher */

/**
 *  The entry point for the CaesarCipher application. CaesarCipher is a Java application that can encrypt or decrypt
 *  a message using a Caesar Shift Substitution Cipher. The encryption key (a letter) is specified by the user.
 *
 *  @author Alexander Fordyce
 *  @version 1.0
 */
public class CaesarCipher {

    /* main */

    /**
     * The entry point for the CaesarCipher application. The main method instantiates the application's frame
     * and displays it.
     * @param args not used
     */
    public static void main(String[] args) {

        CaesarFrame cf = new CaesarFrame();
        cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cf.setVisible(true);

    }

}
