import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderDialog extends JDialog {
    private JTextField txtFieldOrderId;
    private JTextField txtFieldCustomerId;
    private JButton btnAddItem;
    private JButton btnRemoveItem;
    private JButton btnSaveOrder;
    private JButton btnCancel;
    private DefaultListModel<String> listModel;
    private JList<String> itemList;
    private List<Item> orderItems;
    private JComboBox<String> cmbOrderStatus;

    public CreateOrderDialog(Frame parent) {
        super(parent, "Add New Order", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        //Input panel
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        txtFieldOrderId = new JTextField(10);
        txtFieldCustomerId = new JTextField(10);
        cmbOrderStatus = new JComboBox<>(new String[]{"Pending", "Awaiting Payment", "Awaiting Fulfillment", 
        "Awaiting Shipment", "Awaiting Pickup", "Partially Shipped", "Completed", "Shipped", "Cancelled", "Declined", 
        "Refunded", "Disputed", "Manual Verification Required", "Partially Refunded"});
        inputPanel.add(new JLabel("Order ID:"));
        inputPanel.add(txtFieldOrderId);
        inputPanel.add(new JLabel("Customer ID:"));
        inputPanel.add(txtFieldCustomerId);
        inputPanel.add(new JLabel("Order Status:"));
        inputPanel.add(cmbOrderStatus);

        //Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAddItem = new JButton("Add Item");
        btnRemoveItem = new JButton("Remove Item");
        btnSaveOrder = new JButton("Save Order");
        btnCancel = new JButton("Cancel");
        buttonPanel.add(btnAddItem);
        buttonPanel.add(btnRemoveItem);
        buttonPanel.add(btnSaveOrder);
        buttonPanel.add(btnCancel);

        //List panel
        JPanel listPanel = new JPanel(new BorderLayout());
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(itemList);
        listPanel.add(new JLabel("Order Items:"), BorderLayout.NORTH);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        //Action listeners
        btnAddItem.addActionListener(e -> addItem());
        btnRemoveItem.addActionListener(e -> removeItem());
        btnSaveOrder.addActionListener(e -> saveOrder());
        btnCancel.addActionListener(e -> dispose());

        orderItems = new ArrayList<>();
    }

    private void addItem() {
        try {
            int itemId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Item ID:"));

            //TODO: JDBC connection goes here. We need to do a lookup in the database to fetch item info based on the ID, then populate it here
            Item newItem = new Item(itemId, "", 0, 0, 0); //fetchItemDetailsFromDatabase(itemId); //placeholder

            if (newItem != null) {
                orderItems.add(newItem);
                updateItemList();
            } else {
                //If the item is not found in the database, throw error
                JOptionPane.showMessageDialog(this, "Item not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) { //catch invalid inputs
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for Item ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeItem() {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
            orderItems.remove(selectedIndex);
            updateItemList();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to remove.", "Selection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateItemList() {
        listModel.clear();
        for (Item item : orderItems) {
            listModel.addElement(item.toString());
        }
    }

    private void saveOrder() {
        try {
            int orderId = Integer.parseInt(txtFieldOrderId.getText());
            int customerId = Integer.parseInt(txtFieldCustomerId.getText());
            String orderStatus = (String) cmbOrderStatus.getSelectedItem();

            Order newOrder = new Order(orderId, orderItems, customerId, orderStatus); // Updated constructor

            if (newOrder.createOrder()) {
                String message = "Order saved successfully!\nOrder ID: " + orderId + "\nCustomer ID: " + customerId;
                message += "\nOrder Status: " + orderStatus; // Add order status to message
                if (!orderItems.isEmpty()) {
                    message += "\nOrder Items:";
                    for (Item item : orderItems) {
                        message += "\n" + item.toString();
                    }
                }
                JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
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
