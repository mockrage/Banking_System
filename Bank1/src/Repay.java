import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Repay extends JPanel {
    private JPanel RepayPanel; // This field is needed for form binding
    private JLabel labelAccount;
    private JLabel labelAmount;
    private JTextField textFieldAccount;
    private JTextField textFieldAmount;
    private JButton buttonRepay;

    public Repay() {
        // Initialize the panel for the form binding
        RepayPanel = this;

        // Set layout for the panel
        setLayout(new GridLayout(3, 2));

        // Initialize labels and text fields
        labelAccount = new JLabel("Account Number:");
        labelAmount = new JLabel("Repayment Amount:");
        textFieldAccount = new JTextField();
        textFieldAmount = new JTextField();
        buttonRepay = new JButton("Repay Loan");

        // Add action listener to the button
        buttonRepay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRepayment();
            }
        });

        // Add components to the panel
        add(labelAccount);
        add(textFieldAccount);
        add(labelAmount);
        add(textFieldAmount);
        add(buttonRepay);
    }

    private void handleRepayment() {
        String accountNumber = textFieldAccount.getText();
        String amountStr = textFieldAmount.getText();

        // Implement logic to process repayment
        try {
            double amount = Double.parseDouble(amountStr);
            // Add your loan repayment logic here
            // For example, check if the repayment is valid and process it
            // If successful:
            JOptionPane.showMessageDialog(this, "Repayment of " + amount + " successful for account " + accountNumber);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to get the Repay panel
    public JPanel getRepayPanel() {
        return RepayPanel;
    }

    // Main method for testing the Repay panel
    public static void main(String[] args) {
        JFrame frame = new JFrame("Repay Loan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new Repay().getRepayPanel());
        frame.setVisible(true);
    }
}
