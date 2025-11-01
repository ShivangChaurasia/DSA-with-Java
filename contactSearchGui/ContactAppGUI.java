// ContactAppGUI.java
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class ContactAppGUI {
    private static final String contactFilePath = "contacts.txt";

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        manager.loadContacts(contactFilePath);

        JFrame frame = new JFrame("Contact Manager");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(10, 1));

        JTextField nameField = new JTextField();
        JTextField numberField = new JTextField();
        JButton addButton = new JButton("Add Contact");
        JButton searchButton = new JButton("Search");
        JButton updateButton = new JButton("Update Contact");
        JButton deleteButton = new JButton("Delete Contact");
        JTextField searchField = new JTextField();
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Number:"));
        panel.add(numberField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(new JLabel("Search by Name or Number:"));
        panel.add(searchField);
        panel.add(searchButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, new JScrollPane(resultArea));

        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String number = numberField.getText().trim();
            if (!name.isEmpty() && !number.isEmpty()) {
                manager.saveContact(name, number, contactFilePath);
                JOptionPane.showMessageDialog(frame, "Contact added successfully!");
                nameField.setText("");
                numberField.setText("");
            }
            else{
                JOptionPane.showMessageDialog(frame, "Name and Number cannot be empty.");
            }
        });

        updateButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String number = numberField.getText().trim();
            if (!name.isEmpty() && !number.isEmpty()) {
                if (manager.contactExists(name)) {
                    manager.saveContact(name, number, contactFilePath);
                    JOptionPane.showMessageDialog(frame, "Contact updated successfully!");
                } else {
                    manager.saveContact(name, number, contactFilePath);
                    JOptionPane.showMessageDialog(frame, "Contact not found, But added.");
                }
            }
            else{
                JOptionPane.showMessageDialog(frame, "Name and Number cannot be empty.");
            }
        });

        deleteButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                if (manager.contactExists(name)) {
                    manager.deleteContact(name);
                    manager.saveContact("", "", contactFilePath); // Overwrite file with current contacts
                    JOptionPane.showMessageDialog(frame, "Contact deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Contact not found.");
                }
            }else{
                JOptionPane.showMessageDialog(frame, "Name cannot be empty.");
            }
        });

        searchButton.addActionListener(e -> {
            String query = searchField.getText().trim();
            resultArea.setText("");
            if (!query.isEmpty()) {
                List<String> nameResults = manager.search(query);
                List<String> numberResults = manager.searchByNumber(query);
                for (String r : nameResults) resultArea.append(r + "\n");
                for (String r : numberResults) resultArea.append(r + "\n");
            }else{
                JOptionPane.showMessageDialog(frame, "Search query cannot be empty.");
            }
        });

        frame.setVisible(true);
    }
}