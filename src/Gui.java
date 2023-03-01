import javax.swing.*;
import java.awt.*;

import Elements.RoundBorder;

public class Gui extends JFrame {

    public Gui() {
        super("Encrypto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);


        JButton encryptData = new JButton("Encrypt Data");
        encryptData.setBounds(125, 350, 250, 70);
        encryptData.setBackground(Color.decode("#fff39d"));
        encryptData.setFocusable(false);
        encryptData.setBorder(new RoundBorder(10, "#312f1e"));
        this.add(encryptData);


        JButton decryptData = new JButton("Decrypt Data");
        decryptData.setBounds(125, 450, 250, 70);
        decryptData.setBackground(Color.decode("#fff39d"));
        decryptData.setFocusable(false);
        decryptData.setBorder(new RoundBorder(10, "#312f1e"));
        this.add(decryptData);


        encryptData.addActionListener(e -> {
            new EncryptData();
            this.dispose();
        });


        decryptData.addActionListener(e -> {
            new DecryptData();
            this.dispose();
        });



    }

    public static class EncryptData extends JFrame {
        public EncryptData() {
            super("Encrypto - Encryption");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 700);
            setLocationRelativeTo(null);
            setLayout(null);
            setVisible(true);


            JLabel text = new JLabel("Enter the key code ");
            text.setBounds(50, 100, 150, 30);
            text.setFocusable(false);
            this.add(text);

            JTextField key = new JTextField();
            key.setBounds(170, 100, 250, 30);
            key.setFocusable(false);
            this.add(key);


            JButton encrypt = new JButton("Encrypt");
            encrypt.setBounds(75, 450, 150, 40);
            encrypt.setBackground(Color.decode("#fff39d"));
            encrypt.setFocusable(false);
            encrypt.setBorder(new RoundBorder(10, "#312f1e"));
            this.add(encrypt);

            JButton goBack = new JButton("Go Back");
            goBack.setBounds(275, 450, 150, 40);
            goBack.setBackground(Color.decode("#fff39d"));
            goBack.setFocusable(false);
            goBack.setBorder(new RoundBorder(10, "#312f1e"));
            this.add(goBack);


            JLabel browseText = new JLabel("Browse the file");
            browseText.setBounds(50, 300, 150, 30);
            browseText.setFocusable(false);
            this.add(browseText);

            JButton browse = new JButton("Browse");
            browse.setBounds(150, 300, 150, 40);
            browse.setBackground(Color.decode("#fff39d"));
            browse.setFocusable(false);
            browse.setBorder(new RoundBorder(10, "#312f1e"));
            this.add(browse);


            encrypt.addActionListener(e -> {
                //encryption Code
            });





        }
    }


    public static class DecryptData extends JFrame {
        public DecryptData() {
            super("Encrypto  - Decryption");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 700);
            setLocationRelativeTo(null);
            setLayout(null);
            setVisible(true);
        }
    }



    public static void main(String[] args) {
        new Gui();
    }

}
