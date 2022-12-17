package projectsnack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SigninpWindow extends JFrame {

    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 250, 50));
    private JLabel label = new JLabel("Sign In    ");

    private ImageIcon imageIcon = new ImageIcon(new ImageIcon("photo.jpg").getImage().getScaledInstance(200, 500, Image.SCALE_DEFAULT));
    private JLabel image = new JLabel(imageIcon);


    private JLabel labelEmail = new JLabel("Email");
    private JTextField textFieldEmail = new JTextField(15);

    private JLabel labelPass = new JLabel("Password");
    private JTextField textFieldPass = new JTextField(15);

    private JButton button = new JButton("Sign In");
    private JButton buttonSignUp = new JButton("Sign Up now");

    private JPanel signUpPanel = new JPanel(new GridLayout(2, 2, 20, 30));


    public SigninpWindow() {

        setTitle("Snack Factory");
        setSize(645, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        panel.setBackground(Color.darkGray);
        signUpPanel.setBackground(Color.darkGray);
        label.setForeground(Color.white);
        label.setFont(new Font("Serif", Font.BOLD, 40));

        button.setBackground(Color.lightGray);

        buttonSignUp.setForeground(Color.white);
        buttonSignUp.setBackground(Color.darkGray);

        buildPanel();

        panel.add(label);
        panel.add(signUpPanel);
        panel.add(button);
        panel.add(buttonSignUp);

        add(panel, BorderLayout.CENTER);
        add(image, BorderLayout.WEST);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                boolean isExist = false;

                try {
                    File file = new File("users.txt");
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        String name = scanner.nextLine();
                        String email = scanner.nextLine();
                        String phone = scanner.nextLine();
                        String pass = scanner.nextLine();

                        if (email.equals(textFieldEmail.getText()) && pass.equals(textFieldPass.getText())) {

                            isExist = true;
                            setVisible(false);
                            new HomeWindow(textFieldEmail.getText());

                        }
                    }

                } catch (FileNotFoundException e) {
                    e.toString();
                }

                if (!isExist){
                    JOptionPane.showMessageDialog(null,"Information that you have entered is wrong");
                }


            }
        });

        buttonSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

                new SignUpWindow();
            }
        });


    }

    public void buildPanel() {

        labelEmail.setForeground(Color.white);
        labelPass.setForeground(Color.white);


        signUpPanel.add(labelEmail);
        signUpPanel.add(textFieldEmail);
        signUpPanel.add(labelPass);
        signUpPanel.add(textFieldPass);


    }
}
