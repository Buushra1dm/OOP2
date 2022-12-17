package projectsnack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Order extends JFrame{

    private JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));

    private JLabel label = new JLabel("Menu");

    private JPanel coffepanel = new JPanel(new GridLayout(5,1));
    private JLabel labelCoffe = new JLabel("coffe");
    private JCheckBox ch1 = new JCheckBox("Mocha 19.75");
    private JCheckBox ch2 = new JCheckBox("Matcha chia 17.50");
    private JCheckBox ch3 = new JCheckBox("Cappuccino 21.00");
    private JCheckBox ch4 = new JCheckBox("Cold brew 22.00");


    private JPanel juicepanel = new JPanel(new GridLayout(5,1));
    private JLabel labelJuice = new JLabel("Juice");
    private JCheckBox ch5 = new JCheckBox(" Lemon with mint juice 18.75");
    private JCheckBox ch6 = new JCheckBox("Pineapple juice 22.00");
    private JCheckBox ch7 = new JCheckBox("Strawberry juice 22.00");
    private JCheckBox ch8 = new JCheckBox("Cocktail juice 24.00");


    private JPanel snackpanel = new JPanel(new GridLayout(5,1));
    private JLabel labelSnack = new JLabel("Snack");
    private JCheckBox ch9 = new JCheckBox("Cheese Croissant 10.00");
    private JCheckBox ch10 = new JCheckBox("Cheese Break 8.00");
    private JCheckBox ch11 = new JCheckBox("Halloumi Sandwich 15.00");
    private JCheckBox ch12 = new JCheckBox("Chicken Sandwich 18.00");


    private JPanel southPanel = new JPanel();

    private JLabel labelCream = new JLabel("  Add Cream to coffe:");
    private JRadioButton yesCream = new JRadioButton("Yes");
    private JRadioButton noCream = new JRadioButton("NO");

    private JLabel labelIce = new JLabel("Add Ice to Juice:");
    private JRadioButton yesIce= new JRadioButton("Yes");
    private JRadioButton noIce = new JRadioButton("NO");

    private JButton button = new JButton("Go to pay");

    private String email;

    public Order(String email){
        this.email = email;
        setTitle("Menu");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.darkGray);
        setLayout(new FlowLayout());

        label.setFont(new Font("Serif",Font.BOLD,30));
        label.setForeground(Color.white);

        buildCoffe();
        buildJuice();
        buildSnack();
        buildpanel();

        menuPanel.setBackground(Color.darkGray);

        button.setBackground(Color.lightGray);
        button.setForeground(Color.black);

        menuPanel.add(coffepanel);
        menuPanel.add(juicepanel);
        menuPanel.add(snackpanel);
        add(label);
        add(menuPanel);
        add(southPanel);
        add(button);

        setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                double total = 0;

                if (ch1.isSelected()){
                    total+=19.75;
                }
                if (ch2.isSelected()){
                    total+=17.50;
                }if (ch3.isSelected()){
                    total+=21;
                }if (ch4.isSelected()){
                    total+=22;
                }if (ch5.isSelected()){
                    total+=18.75;
                }if (ch6.isSelected()){
                    total+=22;
                }if (ch7.isSelected()){
                    total+=22;
                }if (ch8.isSelected()){
                    total+=24;
                }if (ch9.isSelected()){
                    total+=10;
                }if (ch10.isSelected()){
                    total+=8;
                }if (ch11.isSelected()){
                    total+=15;
                }if (ch12.isSelected()){
                    total+=18;
                }


                setVisible(false);
                 new Payment(total,email);
            }
        });

    }

    public void buildpanel(){

        southPanel.setBackground(Color.darkGray);
        yesIce.setForeground(Color.white);
        noIce.setForeground(Color.white);
        yesCream.setForeground(Color.white);
        noCream.setForeground(Color.white);
        labelIce.setForeground(Color.white);
        labelCream.setForeground(Color.white);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(yesCream);
        group1.add(noCream);
        noIce.setSelected(true);
        noCream.setSelected(true);


        ButtonGroup group2 = new ButtonGroup();
        group2.add(yesIce);
        group2.add(noIce);

        yesCream.setBackground(Color.darkGray);
        yesIce.setBackground(Color.darkGray);
        noCream.setBackground(Color.darkGray);
        noIce.setBackground(Color.darkGray);

        southPanel.add(labelCream);
        southPanel.add(yesCream);
        southPanel.add(noCream);
        southPanel.add(labelIce);
        southPanel.add(yesIce);
        southPanel.add(noIce);


    }

    public void buildCoffe(){

        coffepanel.setBackground(Color.darkGray);


        labelCoffe.setFont(new Font("Serif",Font.BOLD,25));
        labelCoffe.setForeground(Color.white);

        coffepanel.add(labelCoffe);
        coffepanel.add(ch1);
        coffepanel.add(ch2);
        coffepanel.add(ch3);
        coffepanel.add(ch4);

    }

    public void buildJuice(){

        juicepanel.setBackground(Color.darkGray);

        labelJuice.setFont(new Font("Serif",Font.BOLD,25));
        labelJuice.setForeground(Color.white);

        juicepanel.add(labelJuice);
        juicepanel.add(ch5);
        juicepanel.add(ch6);
        juicepanel.add(ch7);
        juicepanel.add(ch8);

    }

    public void buildSnack(){

        snackpanel.setBackground(Color.darkGray);

        labelSnack.setFont(new Font("Serif",Font.BOLD,25));
        labelSnack.setForeground(Color.white);

        snackpanel.add(labelSnack);
        snackpanel.add(ch9);
        snackpanel.add(ch10);
        snackpanel.add(ch11);
        snackpanel.add(ch12);

    }
}
