package projectsnack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow extends JFrame{
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,250,50));
    private JLabel label = new JLabel("Snack Factory");
    private JLabel label2 = new JLabel("Welcome!!");

    private ImageIcon imageIcon = new ImageIcon(new ImageIcon("photo.jpg").getImage().getScaledInstance(200, 500, Image.SCALE_DEFAULT));
    private JLabel image = new JLabel(imageIcon);

    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu help = new JMenu("Help");
    private JMenuItem close = new JMenuItem("Close");
    private JMenuItem aboutUs = new JMenuItem("About Us");


    private JButton buttonWelcome = new JButton("Sign In");





    public FirstWindow(){

        setTitle("Snack Factory");
        setSize(660, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panel.setBackground(Color.darkGray);
        label.setForeground(Color.white);
        label.setFont(new Font("Serif",Font.BOLD,40));
        label2.setFont(new Font("Serif",Font.BOLD,30));
        label2.setForeground(Color.white);


        buttonWelcome.setBackground(Color.lightGray);

        buttonWelcome.setForeground(Color.white);

        panel.add(label);
        panel.add(label2);
        panel.add(buttonWelcome);
        file.add(close);
        help.add(aboutUs);
        menuBar.add(file);
        menuBar.add(help);

        setJMenuBar(menuBar);

        add(panel,BorderLayout.CENTER);
        add(image,BorderLayout.WEST);


        setVisible(true);


        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        aboutUs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Our application helps the customer in ordering the snacks he wants, in addition to saving\n the orders in the customer's account and the possibility of reordering daily if the customer\n wants to do. In Addition, Many students suffer during their study moments from not eating\n or drinking for long periods, which causes fainting and tension, which leads to the inability\n to focus. Through our application, which will provide distinguished services to students in a\n short period of time. Our app makes it easy for the customer to order their daily snacks.");
            }
        });

        buttonWelcome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                 new SigninpWindow();
            }
        });


    }

}
