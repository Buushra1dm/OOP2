package projectsnack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpWindow extends JFrame{

    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,250,50));
    private JLabel label = new JLabel("Sign Up    ");


    private ImageIcon imageIcon = new ImageIcon(new ImageIcon("photo.jpg").getImage().getScaledInstance(200, 550, Image.SCALE_DEFAULT));
    private JLabel image = new JLabel(imageIcon);

    private JLabel labelName = new JLabel("Name");
    private JTextField textFieldName = new JTextField(15);

    private JLabel labelEmail = new JLabel("Email");
    private JTextField textFieldEmail = new JTextField(15);

    private JLabel labelPhone = new JLabel("Phone number");
    private JTextField textFieldPhone = new JTextField(15);

    private JLabel labelPass = new JLabel("Password");
    private JTextField textFieldPass = new JTextField(15);

    private JButton button = new JButton("Sign Up");
    private JButton buttonSignIn = new JButton("Sign In now");


    private JPanel panelSignUp = new JPanel(new GridLayout(4,2,20,30));


    public SignUpWindow(){

        setTitle("Snack Factory");
        setSize(645, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setVisible(true);

        panel.setBackground(Color.darkGray);
        panelSignUp.setBackground(Color.darkGray);
        label.setForeground(Color.white);
        label.setFont(new Font("Serif",Font.BOLD,40));

        button.setBackground(Color.lightGray);

        buttonSignIn.setForeground(Color.white);
        buttonSignIn.setBackground(Color.darkGray);

        buildPanel();


        panel.add(label);
        panel.add(panelSignUp);
        panel.add(button);
        panel.add(buttonSignIn);

        add(panel,BorderLayout.CENTER);
        add(image,BorderLayout.WEST);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    FileWriter writer = new FileWriter("users.txt",true);
                    if (textFieldEmail.getText().contains("@") && textFieldName.getText().length()>2 && textFieldPhone.getText().length() == 10 && textFieldPass.getText().length() > 6){

                        writer.write(textFieldName.getText()+"\n");
                        writer.write(textFieldEmail.getText()+"\n");
                        writer.write(textFieldPhone.getText()+"\n");
                        writer.write(textFieldPass.getText()+"\n");
                        writer.close();


                        setVisible(false);

                        new HomeWindow(textFieldEmail.getText());

                    }else {

                        JOptionPane.showMessageDialog(null,"- email must be with correct format\n" +
                                "- name must be more than 2 character\n" +
                                "- phone number must be 10 digits\n" +
                                "- password must be more than 6");

                    }

                } catch (Exception e) {
                    System.out.println("File error");
                }



            }
        });

        buttonSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

                SigninpWindow s = new SigninpWindow();
            }
        });



    }

    public void buildPanel(){

        labelEmail.setForeground(Color.white);
        labelName.setForeground(Color.white);
        labelPass.setForeground(Color.white);
        labelPhone.setForeground(Color.white);


        panelSignUp.add(labelName);
        panelSignUp.add(textFieldName);
        panelSignUp.add(labelEmail);
        panelSignUp.add(textFieldEmail);
        panelSignUp.add(labelPhone);
        panelSignUp.add(textFieldPhone);
        panelSignUp.add(labelPass);
        panelSignUp.add(textFieldPass);



    }
}
