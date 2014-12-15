package model;

import java.util.HashMap;

/* class CaesarShift */

/**
 * This class provides methods for encrypting and decrypting strings using a Caesar Shift Substitution Cipher
 *
 * @author Alexander Fordyce
 * @version 1.0
 */
public class CaesarShift {

    /** The alphabet */
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** The encryption key */
    private String key;
    /** The alphabet encrypted using the encryption key */
    private String cipherAlphabet;
    /** A HashMap from plaintext to ciphertext */
    private HashMap<String, String> encryption;
    /** A HashMap from ciphertext to plaintext */
    private HashMap<String, String> decryption;

    /* CaesarShift */

    /** The CaesarShift constructor */
    public CaesarShift(String key) {
        setKey(key);
    }

    /* encrypt */

    /**
     * Encrypt a given String plaintext using the set encryption key.
     * @param plaintext
     * @return String ciphertext
     */
    public String encrypt(String plaintext) {
        plaintext = plaintext.toUpperCase();
        if (encryption != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < plaintext.length(); i++) {
                String s = plaintext.substring(i,i+1);
                if (encryption.containsKey(s)) {
                    sb.append(encryption.get(s));
                } else {
                    sb.append(s);
                }
            }
            return sb.toString();
        }
        return "";
    }

    /* decrypt */

    /**
     * Decrypt a given String ciphertext using the set encryption key.
     * @param ciphertext
     * @return String plaintext
     */
    public String decrypt(String ciphertext) {
        ciphertext = ciphertext.toUpperCase();
        if (decryption != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ciphertext.length(); i++) {
                String s = ciphertext.substring(i,i+1);
                if (decryption.containsKey(s)) {
                    sb.append(decryption.get(s));
                } else {
                    sb.append(s);
                }
            }
            return sb.toString();
        }
        return "";
    }

    /* setKey */

    /**
     * Sets the encryption key, as well as the String cipherAlphabet, HashMap encryption, and HashMap decryption
     * @param newKey
     */
    public void setKey(String newKey) {
        this.key = newKey;
        int index;
        for (index = 0; index < alphabet.length(); index++) {
            if (alphabet.substring(index, index+1).equals(key)) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alphabet.charAt((index+i)%26));
        }
        cipherAlphabet = sb.toString();
        encryption = new HashMap<String, String>();
        decryption = new HashMap<String, String>();
        for (int i = 0; i < 26; i++) {
            encryption.put(alphabet.substring(i, i+1), cipherAlphabet.substring(i, i+1));
            decryption.put(cipherAlphabet.substring(i, i+1), alphabet.substring(i, i+1));
        }
    }

}
