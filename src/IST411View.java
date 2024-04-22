import javax.swing.*;
import java.awt.*;

public class IST411View extends JFrame {
    private JTextField txtFieldItemId, txtFieldOrderId, txtFieldUserId;
    private JButton btnGetItem, btnAddItem, btnGetOrder, btnCreateOrder, btnAddUser, btnGetUser;
    private JTextArea txtAreaDisplay;

    public IST411View() {
        //initialize panel and content pane
        setTitle("IST411 Inventory Management System");
        getContentPane().setLayout(new BorderLayout(5, 5));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1)); //increment first number of gridlayout parameters when you want to add a new row to the UI

        JPanel itemPanel = new JPanel(new FlowLayout()); 
        JPanel orderPanel = new JPanel(new FlowLayout());
        JPanel userPanel = new JPanel (new FlowLayout());
        
        //initialize main components
        txtFieldItemId = new JTextField(10);
        txtFieldOrderId = new JTextField(10);
        txtFieldUserId = new JTextField(10);
        btnGetItem = new JButton("Get Item");
        btnAddItem = new JButton("Add New Item");
        btnGetOrder = new JButton("Get Order");
        btnCreateOrder = new JButton("Create New Order");
        btnAddUser = new JButton("Add New User");
        btnGetUser = new JButton("Get User");
        
        //initialize action listeners
        btnGetItem.addActionListener(e -> getItem());
        btnAddItem.addActionListener(e -> openAddItemDialog());
        btnGetOrder.addActionListener(e -> getOrder());
        btnCreateOrder.addActionListener(e -> openCreateOrderDialog());
        btnAddUser.addActionListener (e -> createUser());
        btnGetUser.addActionListener(e -> getUser());

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
        
        
        //add subpanels to the main input panel
        inputPanel.add(itemPanel);
        inputPanel.add(orderPanel);
        inputPanel.add(userPanel);

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
     CreateOrderDialog addOrderDialog = new CreateOrderDialog(this);
     addOrderDialog.setVisible(true);
 }

    private void createUser() {
        //open a new dialog window like AddItemDialog or CreateOrderDialog and get inputs for all user attributes
    }

    private void getUser() {
        //copy code from other get methods. pull user Id from text field, do basic form validation, etc.
     }

    private void openAddressInputDialog() {
        JDialog dialog = new JDialog(this, "Address Input Dialog", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(7, 2));

        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(10);

        JLabel streetLabel = new JLabel("Street:");
        JTextField streetField = new JTextField(30);

        JLabel zipLabel = new JLabel("Zip Code:");
        JTextField zipField = new JTextField(10);

        JLabel cityLabel = new JLabel("City:");
        JTextField cityField = new JTextField(20);

        JLabel stateLabel = new JLabel("State:");
        JTextField stateField = new JTextField(10);

        JLabel countryLabel = new JLabel("Country:");
        JTextField countryField = new JTextField(20);

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Address address = new Address();
                    address.setIntID(Integer.parseInt(idField.getText()));
                    address.setStrStreet(streetField.getText());
                    address.setIntZip(Integer.parseInt(zipField.getText()));
                    address.setStrCity(cityField.getText());
                    address.setStrState(stateField.getText());
                    address.setStrCountry(countryField.getText());

                    submitAddressToDatabase(address);
                    System.out.println("Address data submitted successfully!");
                    dialog.dispose();
                } catch (NumberFormatException | SQLException ex) {
                    System.out.println("Error submitting address data: " + ex.getMessage());
                }
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(streetLabel);
        panel.add(streetField);
        panel.add(zipLabel);
        panel.add(zipField);
        panel.add(cityLabel);
        panel.add(cityField);
        panel.add(stateLabel);
        panel.add(stateField);
        panel.add(countryLabel);
        panel.add(countryField);
        panel.add(submitButton);

        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

