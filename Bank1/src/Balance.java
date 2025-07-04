import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Balance {
    private JPanel checkBalancePanel;
    private JLabel labelAccount;
    private JTextField textFieldAccount;
    private JButton buttonCheckBalance;
    private JLabel labelBalanceResult;
    private BankAccount bankAccount; // Reference to the BankAccount

    // Constructor that accepts a BankAccount
    public Balance(BankAccount bankAccount) {
        this.bankAccount = bankAccount; // Store the reference

        // Create the check balance panel with a GridLayout
        checkBalancePanel = new JPanel(new GridLayout(4, 1, 10, 10));
        checkBalancePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize the components
        labelAccount = new JLabel("Enter Account Number:");
        textFieldAccount = new JTextField();
        buttonCheckBalance = new JButton("Check Balance");
        labelBalanceResult = new JLabel("Balance will be displayed here.", JLabel.CENTER);

        // Add ActionListener to the button to handle the balance check
        buttonCheckBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = textFieldAccount.getText();

                // Get balance from the BankAccount instance
                if (accountNumber.equals(bankAccount.getAccountNumber())) {
                    double balance = bankAccount.getBalance(); // Assuming this method exists

                    // Display the balance in the label
                    labelBalanceResult.setText("Balance: $" + balance);
                } else {
                    labelBalanceResult.setText("Account not found.");
                }
            }
        });

        // Add components to the check balance panel
        checkBalancePanel.add(labelAccount);
        checkBalancePanel.add(textFieldAccount);
        checkBalancePanel.add(buttonCheckBalance);
        checkBalancePanel.add(labelBalanceResult);
    }

    // Method to return the check balance panel
    public JPanel getCheckBalancePanel() {
        return checkBalancePanel;
    }
}
