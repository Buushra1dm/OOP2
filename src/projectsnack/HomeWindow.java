package projectsnack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeWindow extends JFrame{

    private JLabel label = new JLabel("Home Page");

    private JButton button1 = new JButton("Make Order");
    private JButton button2 = new JButton("Show your Bill");
    private JButton button3 = new JButton("Delete Order");

    private JPanel panel = new JPanel();

    private JMenuBar bar = new JMenuBar();

    private JMenu out = new JMenu("Out");

    private JMenuItem signOut = new JMenuItem("Sign Out");

    private String email;



    public HomeWindow(String email){
        this.email = email;
        setTitle("Home");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.darkGray);
        setLayout(new FlowLayout(FlowLayout.CENTER,100,50));
        panel.setBackground(Color.darkGray);

        label.setFont(new Font("Serif",Font.BOLD,30));
        label.setForeground(Color.white);

        button1.setBackground(Color.lightGray);
        button2.setBackground(Color.lightGray);
        button3.setBackground(Color.lightGray);

        add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        add(panel);

        bar.add(out);
        out.add(signOut);

        setJMenuBar(bar);

        setVisible(true);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                Order order = new Order(email);
            }
        });

        signOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                new FirstWindow();


            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getPrice();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteAllBills();
            }
        });



    }

    public void getPrice(){
        double price = 0;
        boolean isExist = false;
        try {
            File file = new File("orders.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String emailFile = scanner.nextLine();
                double priceFile = Double.parseDouble(scanner.nextLine());
                if (emailFile.equals(email)){

                    price = priceFile;
                    isExist = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (isExist){

            JOptionPane.showMessageDialog(null,"                      Bill\n\n" +
                    "Sub-Total:   "+price+"\n\ntax:   "+price*0.15+"\n\ntotal:   "+(price*0.15 + price));

        }else {

            JOptionPane.showMessageDialog(null,"You don't have Order before");

        }
    }

    public void deleteAllBills(){

        ArrayList<String> ordersArray = new ArrayList<>();

        try {
            File file = new File("orders.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String emailFile = scanner.nextLine();
                double priceFile = Double.parseDouble(scanner.nextLine());
                if (emailFile.equals(email)){

                    continue;
                }else {

                    ordersArray.add(emailFile);
                    ordersArray.add(String.valueOf(priceFile));

                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("orders.txt");

            for (int i = 0; i < ordersArray.size(); i++) {

                writer.write(ordersArray.get(i)+"\n");

            }

            writer.close();
        } catch (Exception e) {
            e.toString();
        }

        JOptionPane.showMessageDialog(null,"Your order has been deleted");

    }
}
