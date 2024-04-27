import javax.swing.*;
import java.awt.*;

public class IST411View extends JFrame {
    private JTextField txtFieldItemId, txtFieldOrderId, txtFieldUserId, txtFieldSupplierId;
    private JButton btnGetItem, btnAddItem, btnGetOrder, btnCreateOrder, btnAddUser, btnGetUser, btnGetSupplier, btnAddSupplier;
    private JTextArea txtAreaDisplay;
    
    public IST411View() {
        //initialize panel and content pane
        setTitle("IST411 Inventory Management System");
        getContentPane().setLayout(new BorderLayout(5, 5));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 1)); //increment first number of gridlayout parameters when you want to add a new row to the UI

        JPanel itemPanel = new JPanel(new FlowLayout()); 
        JPanel orderPanel = new JPanel(new FlowLayout());
        JPanel userPanel = new JPanel (new FlowLayout());
        JPanel supplierPanel = new JPanel(new FlowLayout());
        
        //initialize main components
        txtFieldItemId = new JTextField(10);
        txtFieldOrderId = new JTextField(10);
        txtFieldUserId = new JTextField(10);
        txtFieldSupplierId = new JTextField(10);
        btnGetItem = new JButton("Get Item");
        btnAddItem = new JButton("Add New Item");
        btnGetOrder = new JButton("Get Order");
        btnCreateOrder = new JButton("Create New Order");
        btnAddUser = new JButton("Add New User");
        btnGetUser = new JButton("Get User");
        btnGetSupplier = new JButton("Get Supplier");
        btnAddSupplier = new JButton("Add New Supplier");
        
        //initialize action listeners
        btnGetItem.addActionListener(e -> getItem());
        btnAddItem.addActionListener(e -> openAddItemDialog());
        btnGetOrder.addActionListener(e -> getOrder());
        btnCreateOrder.addActionListener(e -> openCreateOrderDialog());
        btnAddUser.addActionListener (e -> openCreateUserDialog());
        btnGetUser.addActionListener(e -> getUser());
        btnGetSupplier.addActionListener(e -> getSupplier());
        btnAddSupplier.addActionListener(e -> openAddSupplierDialog());

        //add item controls
        itemPanel.add(new JLabel("Item ID:"));
        itemPanel.add(txtFieldItemId);
        itemPanel.add(btnGetItem);
        itemPanel.add(btnAddItem);

        //add order controls
        orderPanel.add(new JLabel("Order ID:"));
        orderPanel.add(txtFieldOrderId);
        orderPanel.add(btnGetOrder);
        orderPanel.add(btnCreateOrder);
        
        //add user controls
        userPanel.add(new JLabel("User ID:"));
        userPanel.add(txtFieldUserId);
        userPanel.add(btnGetUser);
        userPanel.add(btnAddUser);
        
        //add supplier controls
        supplierPanel.add(new JLabel("Supplier ID:"));
        supplierPanel.add(txtFieldSupplierId);
        supplierPanel.add(btnGetSupplier);
        supplierPanel.add(btnAddSupplier);
        
        //add subpanels to the main input panel
        inputPanel.add(itemPanel);
        inputPanel.add(orderPanel);
        inputPanel.add(userPanel);
        inputPanel.add(supplierPanel);

        //text area for outputs
        txtAreaDisplay = new JTextArea(5, 20);
        txtAreaDisplay.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(txtAreaDisplay), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
    }

    private void getItem() {
        try {
            int itemId = Integer.parseInt(txtFieldItemId.getText());
            Item item = Item.getItem(itemId);
            if (item != null) {
                txtAreaDisplay.setText(item.toString());
            } else {
                //item valid, but not found in database
                txtAreaDisplay.setText("No item found with ID: " + itemId);
            }
        } catch (NumberFormatException e) {
            //item input invalid
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric item ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openAddItemDialog() {
        AddItemDialog addItemDialog = new AddItemDialog(this);
        addItemDialog.setVisible(true);
    }

    private void getOrder() {
        try {
            int orderId = Integer.parseInt(txtFieldOrderId.getText());
            Order order = Order.getOrder(orderId);
            if (order != null) {
                txtAreaDisplay.setText(order.toString());
            } else {
                //order valid, but not found in database
                txtAreaDisplay.setText("No order found with ID: " + orderId);
            }
        } catch (NumberFormatException e) {
            //order input invalid
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric order ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void openCreateOrderDialog() {
        CreateOrderDialog createOrderDialog = new CreateOrderDialog(this);
        createOrderDialog.setVisible(true);
    }

    private void openCreateUserDialog() {
        CreateUserDialog createUserDialog = new CreateUserDialog(this);
        createUserDialog.setVisible(true);
    }

    private void getUser() {
        try {
            int userId = Integer.parseInt(txtFieldUserId.getText());
            User user = User.getUser(userId);
            if (user != null) {
                txtAreaDisplay.setText(user.toString());
            } else {
                //user valid, but not found in database
                txtAreaDisplay.setText("No user found with ID: " + userId);
            }
        } catch (NumberFormatException e) {
            //user input invalid
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric user ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        private void getSupplier() {
        try {
            int supplierId = Integer.parseInt(txtFieldSupplierId.getText());
            Supplier supplier = Supplier.getSupplier(supplierId);
            if (supplier != null) {
                txtAreaDisplay.setText(supplier.toString());
            } else {
                //supplier valid, but not found in database
                txtAreaDisplay.setText("No supplier found with ID: " + supplierId);
            }
        } catch (NumberFormatException e) {
            //supplier input invalid
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric supplier ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openAddSupplierDialog() {
        AddSupplierDialog addSupplierDialog = new AddSupplierDialog(this);
        addSupplierDialog.setVisible(true);
    }

}
