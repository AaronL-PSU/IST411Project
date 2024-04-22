import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInputUI extends JFrame {

    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton submitButton;

    public UserInputUI() {
        setTitle("User Information Input");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10)); // Grid layout with 6 rows, 2 columns

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        add(idLabel);
        add(idField);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        add(firstNameLabel);
        add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        add(lastNameLabel);
        add(lastNameField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        add(usernameLabel);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        add(passwordLabel);
        add(passwordField);

        submitButton = new JButton("Submit");
        add(submitButton);

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve input values
                int id = Integer.parseInt(idField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Create a User object with the input values
                User user = createUser(id, firstName, lastName, username, password);
                System.out.println("User created: " + user);
            }
        });
    }

    private User createUser(int id, String firstName, String lastName, String username, String password) {
        User user = new User() {
        };
        user.setIntID(id);
        user.setStrFirstName(firstName);
        user.setStrLastName(lastName);
        user.setStrUsername(username);
        user.setStrPassword(password);
        return user;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserInputUI userInputUI = new UserInputUI();
                userInputUI.setVisible(true);
            }
        });
    }
}
