import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit{
    private JPanel depositPanel;
    private JLabel labelAccount;
    private JLabel labelAmount;
    private JLabel labelMoney;
    private JTextField textField1; // For Account Number
    private JTextField textField2; // For Amount to Deposit
    private JButton buttonSubmit; // Submit button for deposit

    public Deposit() {
        // Create the deposit panel with a GridLayout for a neat arrangement of components
        depositPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        depositPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize the labels and text fields
        labelAccount = new JLabel("Account Number:");
        textField1 = new JTextField();
        labelAmount = new JLabel("Amount to Deposit:");
        textField2 = new JTextField();
        labelMoney = new JLabel("Money Status:");
        JLabel labelMoneyStatus = new JLabel("Enter amount and click Submit"); // Status message label

        // Initialize the Submit button and add an ActionListener to handle the click event
        buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = textField1.getText();
                String amountText = textField2.getText();
                double amount;

                try {
                    amount = Double.parseDouble(amountText);
                    // Simulate deposit logic (replace with actual logic as needed)
                    if (isDepositSuccessful(accountNumber, amount)) {
                        labelMoneyStatus.setText("Deposit Successful!");
                        JOptionPane.showMessageDialog(depositPanel, "Deposit Successful!");
                    } else {
                        labelMoneyStatus.setText("Deposit Failed!");
                        JOptionPane.showMessageDialog(depositPanel, "Deposit Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    labelMoneyStatus.setText("Invalid amount entered.");
                    JOptionPane.showMessageDialog(depositPanel, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the deposit panel
        depositPanel.add(labelAccount);
        depositPanel.add(textField1);
        depositPanel.add(labelAmount);
        depositPanel.add(textField2);
        depositPanel.add(labelMoney);
        depositPanel.add(labelMoneyStatus);
        depositPanel.add(new JLabel()); // Empty cell for spacing
        depositPanel.add(buttonSubmit);
    }

    // Simulated deposit logic (Replace this with actual logic)
    private boolean isDepositSuccessful(String accountNumber, double amount) {
        // Placeholder logic to determine deposit success
        return amount > 0; // Replace with real validation for deposit process
    }

    // Method to return the deposit panel
    public JPanel getDepositPanel() {
        return depositPanel;
    }
}
