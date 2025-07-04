import javax.swing.*;
import java.awt.*;

public class Transfer extends JPanel {
    private JPanel transferPanel; // Corrected to match the expected field name
    private JLabel labelFromAccount;
    private JLabel labelToAccount;
    private JLabel labelAmount;
    private JTextField textFieldFromAccount;
    private JTextField textFieldToAccount;
    private JTextField textFieldAmount;
    private JButton buttonTransfer;

    public Transfer() {
        // Create the transfer panel and set its layout
        transferPanel = new JPanel(new GridLayout(4, 2)); // Ensuring this is the correct field name
        transferPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize components
        labelFromAccount = new JLabel("From Account:");
        labelToAccount = new JLabel("To Account:");
        labelAmount = new JLabel("Amount:");
        textFieldFromAccount = new JTextField();
        textFieldToAccount = new JTextField();
        textFieldAmount = new JTextField();
        buttonTransfer = new JButton("Transfer");

        // Add action listener for the transfer button
        buttonTransfer.addActionListener(e -> transferFunds());

        // Add components to the transfer panel
        transferPanel.add(labelFromAccount);
        transferPanel.add(textFieldFromAccount);
        transferPanel.add(labelToAccount);
        transferPanel.add(textFieldToAccount);
        transferPanel.add(labelAmount);
        transferPanel.add(textFieldAmount);
        transferPanel.add(new JLabel()); // Empty cell for spacing
        transferPanel.add(buttonTransfer);
    }

    // Method to handle fund transfer
    private void transferFunds() {
        String fromAccount = textFieldFromAccount.getText();
        String toAccount = textFieldToAccount.getText();
        String amountStr = textFieldAmount.getText();

        // Simple validation
        if (fromAccount.isEmpty() || toAccount.isEmpty() || amountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Perform transfer logic here (you may want to check if the accounts are valid and if funds are sufficient)
        // For demonstration, let's assume the transfer is always successful:
        JOptionPane.showMessageDialog(this, "Transfer of $" + amount + " from " + fromAccount + " to " + toAccount + " successful!", "Transfer Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to get the Transfer panel
    public JPanel getTransferPanel() {
        return transferPanel; // Ensure this returns the correct panel
    }

    // Main method for testing the Transfer panel
    public static void main(String[] args) {
        JFrame frame = new JFrame("Transfer Funds");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        Transfer transfer = new Transfer();
        frame.add(transfer.getTransferPanel());
        frame.setVisible(true);
    }
}
