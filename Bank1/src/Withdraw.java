import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdraw {
    private JPanel withdrawPanel;
    private JLabel labelAccount;
    private JLabel labelAmount;
    private JLabel labelMoney;
    private JTextField textField1; // For Account Number
    private JTextField textField2; // For Amount to Withdraw
    private JButton buttonOk;

    public Withdraw() {
        // Create the Withdraw panel with a GridLayout for a neat arrangement of components
        withdrawPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        withdrawPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize the labels and text fields
        labelAccount = new JLabel("Account Number:");
        textField1 = new JTextField();
        labelAmount = new JLabel("Amount to Withdraw:");
        textField2 = new JTextField();
        labelMoney = new JLabel("Money Status:");
        JLabel labelMoneyStatus = new JLabel("Enter amount and click OK"); // Status message label

        // Initialize the OK button and add an ActionListener to handle the click event
        buttonOk = new JButton("OK");
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = textField1.getText();
                String amountText = textField2.getText();
                double amount;

                try {
                    amount = Double.parseDouble(amountText);
                    // Simulate withdrawal logic (replace with actual logic as needed)
                    if (isWithdrawalSuccessful(accountNumber, amount)) {
                        labelMoneyStatus.setText("Withdrawal Successful!");
                        JOptionPane.showMessageDialog(withdrawPanel, "Withdrawal Successful!");
                    } else {
                        labelMoneyStatus.setText("Insufficient Funds!");
                        JOptionPane.showMessageDialog(withdrawPanel, "Insufficient Funds!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    labelMoneyStatus.setText("Invalid amount entered.");
                    JOptionPane.showMessageDialog(withdrawPanel, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the Withdraw panel
        withdrawPanel.add(labelAccount);
        withdrawPanel.add(textField1);
        withdrawPanel.add(labelAmount);
        withdrawPanel.add(textField2);
        withdrawPanel.add(labelMoney);
        withdrawPanel.add(labelMoneyStatus);
        withdrawPanel.add(new JLabel()); // Empty cell for spacing
        withdrawPanel.add(buttonOk);
    }

    // Simulated withdrawal logic (Replace this with actual logic)
    private boolean isWithdrawalSuccessful(String accountNumber, double amount) {
        // Placeholder logic to determine withdrawal success
        return amount <= 1000; // Replace with real validation for account balance check
    }

    // Method to return the Withdraw panel
    public JPanel getWithdrawPanel() {
        return withdrawPanel;
    }
}
