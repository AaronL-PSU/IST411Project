import javax.swing.*;
import java.awt.*;

public class CreateCustomerDialog extends JDialog {
    private JTextField txtCustomerID, txtCustomerCardNumber, txtFirstName, txtLastName, txtUsername, txtPassword, txtEmail;
    private JButton btnAddress;
    private Address address;
    private Frame parentFrame;

    public CreateCustomerDialog(Frame parent) {
        super(parent, "Customer Details", true);
        this.parentFrame = parent; //Storing the parent frame for later use
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(8, 2));
        txtCustomerID = new JTextField();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtUsername = new JTextField();
        txtPassword = new JPasswordField(); //hide input for password field
        txtCustomerCardNumber = new JTextField();
        txtEmail = new JTextField();

        formPanel.add(new JLabel("Customer ID:"));
        formPanel.add(txtCustomerID);
        formPanel.add(new JLabel("First Name:"));
        formPanel.add(txtFirstName);
        formPanel.add(new JLabel("Last Name:"));
        formPanel.add(txtLastName);
        formPanel.add(new JLabel("Username:"));
        formPanel.add(txtUsername);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(txtPassword);
        formPanel.add(new JLabel("Customer Card Number:"));
        formPanel.add(txtCustomerCardNumber);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(txtEmail);

        btnAddress = new JButton("Input Address");
        btnAddress.addActionListener(e -> openAddressDialog());

        formPanel.add(new JLabel("Address:"));
        formPanel.add(btnAddress);

        add(formPanel, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");

        btnSave.addActionListener(e -> saveCustomer());
        btnCancel.addActionListener(e -> dispose());

        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        return buttonPanel;
    }

    private void openAddressDialog() {
        AddressInputDialog addressDialog = new AddressInputDialog(parentFrame); //passing in parent frame
        addressDialog.setVisible(true);
        this.address = addressDialog.getAddress();
    }

    private void saveCustomer() {
        String customerID = txtCustomerID.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String cardNumber = txtCustomerCardNumber.getText();
        String email = txtEmail.getText();

        Address address = this.address;
        Email customerEmail = new Email();
        customerEmail.setAddress(email);

        //Create Customer object
        Customer customer = new Customer(Integer.parseInt(customerID), firstName, lastName, username, password, address, customerEmail, cardNumber);

        //TODO: JDBC connection goes here

        String message = "Customer saved successfully!\nCustomer ID: " + customerID + "\nFirst Name: " + firstName +
                         "\nLast Name: " + lastName + "\nUsername: " + username + "\nPassword: " + password +
                         "\nCustomer Card Number: " + cardNumber;
        if (address != null) {
            message += "\nAddress: " + address.toString();
        }
        message += "\nEmail: " + email;
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);

        dispose();
    }
}
