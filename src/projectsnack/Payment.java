package projectsnack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Payment extends JFrame{


    private JLabel label = new JLabel("Bill Information");
    private JPanel billPanel = new JPanel(new GridLayout(3,2,20,50));

    private JLabel subtotalLabel = new JLabel("SubTotal:");
    private JLabel subTotal = new JLabel("0");
    private JLabel taxLabel = new JLabel("Tax:");
    private JLabel tax = new JLabel("0");
    private JLabel totalLabel = new JLabel("Total:");
    private JLabel total = new JLabel("0");


    private JPanel secondpanel = new JPanel(new GridLayout(2,2,25,5));

    private JLabel infoLabel = new JLabel("Delivery Information");

    private JLabel timelabel = new JLabel("Time");
    private JLabel locationLabel = new JLabel("Location");

    private String[]  times= {"4:00 PM","5:00 PM","6:00 PM","7:00 PM","8:00 PM"};

    private JComboBox combo = new JComboBox(times);
    private JTextField textFieldLocation = new JTextField(10);


    private JPanel lastPanel = new JPanel();

    private JLabel paymentLabel = new JLabel("Payment :");
    private JRadioButton cash = new JRadioButton("Cash");
    private JRadioButton applePay = new JRadioButton("Apple pay");
    private JRadioButton Credit = new JRadioButton("Credit card");


    private JButton button = new JButton("Done");

    private double totalPrice ;

    public Payment(double totalPrice,String email){
        this.totalPrice = totalPrice;

        setTitle("Payment");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.darkGray);
        setLayout(new FlowLayout(FlowLayout.CENTER,100,50));

        infoLabel.setFont(new Font("Serif",Font.BOLD,25));
        infoLabel.setForeground(Color.white);

        label.setForeground(Color.white);
        label.setFont(new Font("Serif",Font.BOLD,25));

        button.setBackground(Color.lightGray);
        button.setForeground(Color.white);


        secondpanel.add(timelabel);
        secondpanel.add(locationLabel);

        secondpanel.add(combo);
        secondpanel.add(textFieldLocation);

        billPanel.add(subtotalLabel);
        billPanel.add(subTotal);
        billPanel.add(taxLabel);
        billPanel.add(tax);
        billPanel.add(totalLabel);
        billPanel.add(total);

        ButtonGroup group = new ButtonGroup();
        group.add(cash);
        group.add(applePay);
        group.add(Credit);
        applePay.setSelected(true);

        lastPanel.add(paymentLabel);
        lastPanel.add(cash);
        lastPanel.add(applePay);
        lastPanel.add(Credit);

        add(label);
        add(billPanel);
        add(infoLabel);
        add(secondpanel);
        add(lastPanel);
        add(button);

        setVisible(true);

        setTotal();


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    FileWriter file = new FileWriter("orders.txt",true);
                    file.write(email+"\n");
                    file.write(totalPrice+"\n");
                    file.close();
                    JOptionPane.showMessageDialog(null,"Thank You!!");
                    setVisible(false);

                    new HomeWindow(email);
                } catch (Exception e) {
                    e.toString();
                }
            }
        });


    }

    private void setTotal() {

        subTotal.setText(String.valueOf(totalPrice));
        tax.setText(String.valueOf(totalPrice*0.15));

        total.setText(String.valueOf(totalPrice*0.15 + totalPrice));

    }
}
