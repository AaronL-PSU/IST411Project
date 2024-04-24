import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AddressInputDialog {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    static void createAndShowGUI() {
        JFrame frame = new JFrame("Address Input App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void submitAddressToDatabase(Address address) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO addresses (id, street, zip, city, state, country) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, address.getIntID());
                pstmt.setString(2, address.getStrStreet());
                pstmt.setInt(3, address.getIntZip());
                pstmt.setString(4, address.getStrCity());
                pstmt.setString(5, address.getStrState());
                pstmt.setString(6, address.getStrCountry());

                pstmt.executeUpdate();
            }
        }
    }
}
