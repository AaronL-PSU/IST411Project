import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateOrderDialog extends JDialog {
    private JTextField txtFieldOrderId;
    private JTextField txtFieldCustomerId;
    private JButton btnSaveOrder;
    private JButton btnCancelOrder;

    public CreateOrderDialog(Frame parent) {
        super(parent, "Add New Order", true);
        setSize(350, 300);
        setLocationRelativeTo(parent);
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new GridLayout(0, 2));

        //initialize components
        txtFieldOrderId = new JTextField(10);
        txtFieldCustomerId = new JTextField(10);

        btnSaveOrder = new JButton("Save Order");
        btnCancelOrder = new JButton("Cancel");

        btnSaveOrder.addActionListener(e -> saveOrder());
        btnCancelOrder.addActionListener(e -> dispose());

        //add components to dialog
        add(new JLabel("Order ID:"));
        add(txtFieldOrderId);
        add(new JLabel("Customer ID:"));
        add(txtFieldCustomerId);
        add(btnSaveOrder);
        add(btnCancelOrder);
    }

    private void saveOrder() {
        try {
            int orderId = Integer.parseInt(txtFieldOrderId.getText());
            int customerId = Integer.parseInt(txtFieldCustomerId.getText());

            Order newOrder = new Order(orderId, new ArrayList<>(), customerId);

            if (newOrder.createOrder()) {
                JOptionPane.showMessageDialog(this, "Order saved successfully!");
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save order.", "Error", JOptionPane.ERROR_MESSAGE);
                //valid order inputs, but failed to add
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Order ID and Customer ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            //invalid order inputs
        }
    }
}
