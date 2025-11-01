import java.awt.BorderLayout;
import  javax.swing.*;
public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel NameLabel = new JLabel("Name: ");
        JTextField NameField = new JTextField(20);
        JLabel Age = new JLabel("Age: ");
        JTextField AgeField = new JTextField(20);

        panel.add(NameLabel);
        panel.add(NameField);
        panel.add(Age);
        panel.add(AgeField);

        frame.getContentPane().add(panel);
        frame.getContentPane().add(BorderLayout.EAST,new JButton("Submit"));

        frame.setVisible(true);
    }
}