import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddSupplierDialog extends JDialog {
    private JTextField txtFieldSupplierId;
    private JTextField txtFieldSupplierName;
    private JTextField txtFieldContactNumber;
    private JButton btnSaveSupplier;
    private JButton btnCancel;

    public AddSupplierDialog(Frame parent) {
        super(parent, "Add New Supplier", true);
        setSize(400, 200);
        setLocationRelativeTo(parent);
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new GridLayout(4, 2));

        txtFieldSupplierId = new JTextField(10);
        txtFieldSupplierName = new JTextField(10);
        txtFieldContactNumber = new JTextField(10);
        btnSaveSupplier = new JButton("Save Supplier");
        btnCancel = new JButton("Cancel");

        add(new JLabel("Supplier ID:"));
        add(txtFieldSupplierId);
        add(new JLabel("Supplier Name:"));
        add(txtFieldSupplierName);
        add(new JLabel("Contact Number:"));
        add(txtFieldContactNumber);
        add(btnSaveSupplier);
        add(btnCancel);

        btnSaveSupplier.addActionListener(e -> saveSupplier());
        btnCancel.addActionListener(e -> dispose());
    }

    private void saveSupplier() {
        try {
            int supplierId = Integer.parseInt(txtFieldSupplierId.getText());
            String supplierName = txtFieldSupplierName.getText();
            String contactNumber = txtFieldContactNumber.getText();

            Supplier newSupplier = new Supplier(supplierId, supplierName, contactNumber);

            if (newSupplier.saveSupplier()) {
                String message = "Supplier saved successfully!\nSupplier ID: " + supplierId + "\nSupplier Name: " + supplierName + "\nContact Number: " + contactNumber;
                JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save supplier.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric value for Supplier ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
