import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenAccount {
    private JPanel openAccountPanel;
    private JLabel lastNameLabel; // Class-level declaration for last name label
    private JLabel accountNumberLabel; // Class-level declaration for account number label
    private JLabel initialDepositLabel; // Class-level declaration for initial deposit label
    private JTextField lastNameField;
    private JTextField accountNumberField;
    private JTextField initialDepositField;
    private JButton submitButton;

    public OpenAccount() {
        // Create the panel
        openAccountPanel = new JPanel();
        openAccountPanel.setLayout(new GridLayout(4, 2)); // 4 rows, 2 columns

        // Initialize labels
        lastNameLabel = new JLabel("Last Name:");
        accountNumberLabel = new JLabel("Account Number:");
        initialDepositLabel = new JLabel("Initial Deposit:");

        // Create text fields
        lastNameField = new JTextField();
        accountNumberField = new JTextField();
        initialDepositField = new JTextField();

        // Create submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to handle account creation
                String lastName = lastNameField.getText();
                String accountNumber = accountNumberField.getText();
                String initialDeposit = initialDepositField.getText();

                // Display a message upon successful account creation (add validation as needed)
                JOptionPane.showMessageDialog(openAccountPanel, "Account created successfully!\n"
                        + "Last Name: " + lastName + "\n"
                        + "Account Number: " + accountNumber + "\n"
                        + "Initial Deposit: " + initialDeposit);
            }
        });

        // Add components to the panel
        openAccountPanel.add(lastNameLabel);
        openAccountPanel.add(lastNameField);
        openAccountPanel.add(accountNumberLabel);
        openAccountPanel.add(accountNumberField);
        openAccountPanel.add(initialDepositLabel);
        openAccountPanel.add(initialDepositField);
        openAccountPanel.add(submitButton);
    }

    public JPanel getOpenAccountPanel() {
        return openAccountPanel;
    }

    public static void main(String[] args) {
        // Create frame to display the Open Account panel
        JFrame frame = new JFrame("Open Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        OpenAccount openAccountPanel = new OpenAccount();
        frame.add(openAccountPanel.getOpenAccountPanel());

        frame.setVisible(true);
    }
}
