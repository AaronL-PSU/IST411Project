import javax.swing.*;
import java.awt.*;

public class CreateUserDialog extends JDialog {
    private Frame parentFrame;

    public CreateUserDialog(Frame parent) {
        super(parent, "Add User", true);
        this.parentFrame = parent; //Store the parent frame for later use
        initializeUI();
        pack();
        setLocationRelativeTo(parent);
    }

    private void initializeUI() {
        setLayout(new GridLayout(1, 2));

        JButton btnAddEmployee = new JButton("Add Employee");
        btnAddEmployee.addActionListener(e -> openCreateEmployeeDialog());

        JButton btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.addActionListener(e -> openCreateCustomerDialog());

        add(btnAddEmployee);
        add(btnAddCustomer);
    }

    private void openCreateEmployeeDialog() {
        CreateEmployeeDialog createEmployeeDialog = new CreateEmployeeDialog(parentFrame); //passing in parent frame
        createEmployeeDialog.setVisible(true);
        dispose();
    }

    private void openCreateCustomerDialog() {
        CreateCustomerDialog createCustomerDialog = new CreateCustomerDialog(parentFrame); //passing in parent frame
        createCustomerDialog.setVisible(true);
        dispose();
    }
}
