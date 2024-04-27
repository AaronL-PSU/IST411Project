import javax.swing.*;
import java.awt.*;

public class CreateEmployeeDialog extends JDialog {
    private JTextField txtEmployeeID, txtSalary, txtName, txtRole, txtEmail;
    private JButton btnAddress;
    private Address address;
    private Frame parentFrame;

    public CreateEmployeeDialog(Frame parent) {
        super(parent, "Employee Details", true);
        this.parentFrame = parent; //Store the parent frame for later use
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        txtEmployeeID = new JTextField();
        txtName = new JTextField();
        txtSalary = new JTextField();
        txtRole = new JTextField();
        txtEmail = new JTextField();

        formPanel.add(new JLabel("Employee ID:"));
        formPanel.add(txtEmployeeID);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(txtName);
        formPanel.add(new JLabel("Salary:"));
        formPanel.add(txtSalary);
        formPanel.add(new JLabel("Role:"));
        formPanel.add(txtRole);
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

        btnSave.addActionListener(e -> saveEmployee());
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

    private void saveEmployee() {
        String employeeID = txtEmployeeID.getText();
        String name = txtName.getText();
        String salary = txtSalary.getText();
        String role = txtRole.getText();

        Address address = this.address;
        String email = txtEmail.getText();

        Email employeeEmail = new Email();
        employeeEmail.setAddress(email);

        //Create Employee object
        Employee employee = new Employee(Integer.parseInt(employeeID), name, "", "", "", address, employeeEmail, 0, null, Double.parseDouble(salary));

        //TODO: JDBC connection goes here

        String message = "Employee saved successfully!\nEmployee ID: " + employeeID + "\nName: " + name + "\nSalary: " + salary + "\nRole: " + role;
        if (address != null) {
            message += "\nAddress: " + address.toString();
        }
        message += "\nEmail: " + email;
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);

        dispose();
    }
}
