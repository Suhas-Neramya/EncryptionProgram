import Elements.RoundBorder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

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

        JLabel logo = new JLabel(new ImageIcon("src\\images\\logo.png"));
        logo.setBounds(-50, 50, 600, 250);
        this.add(logo);



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
            key.setEnabled(true);
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

            JLabel imagePath = new JLabel();
            imagePath.setBounds(50, 200, 400, 30);
            imagePath.setFocusable(false);



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


            browse.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new java.io.File("."));
                fileChooser.setDialogTitle("Select the image");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    imagePath.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            });


            encrypt.addActionListener(e -> {
                String enKey = key.getText();
                if (enKey.length()<=24){
                    enKey= enKey+"000000000000000000000000";
                }
                enKey = enKey.substring(0, 24);
                FileInputStream inFile;
                FileOutputStream outFile;
                try {
                    inFile = new FileInputStream(imagePath.getText());
                    outFile = new FileOutputStream("./src/EncryptedImages/"+LocalDateTime.now().toString().replace(".","").replace(":","") +".png");
                    Key secretKey = new SecretKeySpec(enKey.getBytes(), "AES");
                    Cipher cipher = Cipher.getInstance("AES");
                    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                    byte[] input = new byte[64];
                    int bytesRead;
                    while ((bytesRead = inFile.read(input)) != -1) {
                        byte[] output = cipher.update(input, 0, bytesRead);
                        outFile.write(output);
                    }
                    byte[] output = cipher.doFinal();
                    outFile.write(output);
                    inFile.close();
                    outFile.flush();
                    outFile.close();
                    System.out.println("File Encrypted.");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException
                         | InvalidKeyException | IOException
                         | IllegalBlockSizeException | BadPaddingException EX) {
                    System.out.println(EX.getMessage());
                }
            });



            goBack.addActionListener(e -> {
                new Gui();
                this.dispose();
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

            JLabel text = new JLabel("Enter the key code ");
            text.setBounds(50, 100, 150, 30);
            text.setFocusable(false);
            this.add(text);

            JTextField key = new JTextField();
            key.setBounds(170, 100, 250, 30);
            this.add(key);


            JButton decrypt = new JButton("Decrypt");
            decrypt.setBounds(75, 450, 150, 40);
            decrypt.setBackground(Color.decode("#fff39d"));
            decrypt.setFocusable(false);
            decrypt.setBorder(new RoundBorder(10, "#312f1e"));
            this.add(decrypt);

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


            decrypt.addActionListener(e -> {

            });

            goBack.addActionListener(e -> {
                new Gui();
                this.dispose();
            });

        }
    }



    public static void main(String[] args) {
        new Gui();
    }

}
