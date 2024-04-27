import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddressInputDialog extends JDialog {
    private JTextField streetField;
    private JTextField zipField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField countryField;
    private JButton submitButton;
    private Address address;

    public AddressInputDialog(Frame parent) {
        super(parent, "Address Input", true);
        initializeUI();
        pack();
        setLocationRelativeTo(parent);
    }

    private void initializeUI() {
        setLayout(new GridLayout(7, 2));

        streetField = new JTextField(30);
        zipField = new JTextField(10);
        cityField = new JTextField(20);
        stateField = new JTextField(10);
        countryField = new JTextField(20);

        add(new JLabel("Street:"));
        add(streetField);
        add(new JLabel("Zip Code:"));
        add(zipField);
        add(new JLabel("City:"));
        add(cityField);
        add(new JLabel("State:"));
        add(stateField);
        add(new JLabel("Country:"));
        add(countryField);
        add(new JLabel ());//placeholder so the button goes to the right side
        
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitAddress());
        add(submitButton);
    }

    private void submitAddress() {
    try {
        address = new Address();
        address.setStrStreet(streetField.getText());
        address.setIntZip(Integer.parseInt(zipField.getText()));
        address.setStrCity(cityField.getText());
        address.setStrState(stateField.getText());
        address.setStrCountry(countryField.getText());
        
        String message = "Address added successfully!\nID: " + address.getIntID() + "\nStreet: " + address.getStrStreet() +
                         "\nZip Code: " + address.getIntZip() + "\nCity: " + address.getStrCity() + "\nState: " +
                         address.getStrState() + "\nCountry: " + address.getStrCountry();
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
        
        dispose();
        } catch (NumberFormatException ex) {
            //catch invalid input
            JOptionPane.showMessageDialog(this, "Invalid input in fields, please check the data.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Address getAddress() {
        return address;
    }
}
