import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddItemDialog extends JDialog {
    private JTextField txtFieldId;
    private JTextField txtFieldName;
    private JTextField txtFieldQuantity;
    private JTextField txtFieldPrice;
    private JTextField txtFieldReorderQuantity;
    private JButton btnSave;
    private JButton btnCancel;

    public AddItemDialog(Frame parent) {
        super(parent, "Add New Item", true);
        setSize(350, 300);
        setLocationRelativeTo(parent);
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new GridLayout(0, 2));
        //initalize main components
        txtFieldId = new JTextField(10);
        txtFieldName = new JTextField(10);
        txtFieldQuantity = new JTextField(10);
        txtFieldPrice = new JTextField(10);
        txtFieldReorderQuantity = new JTextField(10);

        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");

        btnSave.addActionListener(e -> saveItem());
        btnCancel.addActionListener(e -> dispose());
        
        //add components to the dialog
        add(new JLabel("Item ID:"));
        add(txtFieldId);
        add(new JLabel("Item Name:"));
        add(txtFieldName);
        add(new JLabel("Quantity:"));
        add(txtFieldQuantity);
        add(new JLabel("Price:"));
        add(txtFieldPrice);
        add(new JLabel("Reorder Quantity:"));
        add(txtFieldReorderQuantity);
        add(btnSave);
        add(btnCancel);
    }

    private void saveItem() {
        try {
            int id = Integer.parseInt(txtFieldId.getText());
            String name = txtFieldName.getText();
            int qty = Integer.parseInt(txtFieldQuantity.getText());
            int price = Integer.parseInt(txtFieldPrice.getText());
            int reorderQty = Integer.parseInt(txtFieldReorderQuantity.getText());

            Item newItem = new Item(id, name, qty, price, reorderQty);

            if (newItem.saveItem()) {
                JOptionPane.showMessageDialog(this, "Item saved successfully!\n" +
                                                   "Item ID: " + id + "\n" +
                                                   "Item Name: " + name + "\n" +
                                                   "Quantity: " + qty + "\n" +
                                                   "Price: " + price + "\n" +
                                                   "Reorder Quantity: " + reorderQty);
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save item.", "Error", JOptionPane.ERROR_MESSAGE);
                //throw error if item was not saved, but was valid
            }
        } catch (NumberFormatException e) {
            //throw error if invalid/missing values are entered
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for ID, Quantity, Price, and Reorder Quantity.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
