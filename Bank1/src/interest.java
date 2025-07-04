import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interest extends JPanel {
    private JPanel interestPanel; // This field is used for form binding
    private JLabel labelLoanAmount; // Label for loan amount input
    private JLabel labelInterestRate; // Label for fixed interest rate
    private JLabel labelCalculatedInterest; // Label to display calculated interest
    private JTextField textFieldLoanAmount; // Text field for user input
    private JButton buttonCalculate; // Button to calculate interest

    public interest() {
        // Initialize the panel for the form binding
        interestPanel = this;

        // Set layout for the panel
        setLayout(new GridLayout(4, 2));

        // Initialize components
        labelInterestRate = new JLabel("Fixed Interest Rate: 15%", JLabel.LEFT);
        labelLoanAmount = new JLabel("Enter Loan Amount: ", JLabel.RIGHT);
        labelCalculatedInterest = new JLabel("Calculated Interest: ", JLabel.RIGHT);

        textFieldLoanAmount = new JTextField();
        buttonCalculate = new JButton("Calculate Interest");

        // Add action listener to the button
        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateInterest();
            }
        });

        // Add components to the panel
        add(labelInterestRate);
        add(new JLabel()); // Empty cell for alignment
        add(labelLoanAmount);
        add(textFieldLoanAmount);
        add(buttonCalculate);
        add(new JLabel()); // Empty cell for alignment
        add(labelCalculatedInterest);
        add(new JLabel()); // Empty cell for alignment
    }

    private void calculateInterest() {
        try {
            // Get loan amount from text field
            double loanAmount = Double.parseDouble(textFieldLoanAmount.getText());
            // Fixed interest rate
            double interestRate = 0.15; // 15%
            // Calculate interest
            double calculatedInterest = loanAmount * interestRate;
            // Display calculated interest
            labelCalculatedInterest.setText("Calculated Interest: $" + String.format("%.2f", calculatedInterest)); // Format to 2 decimal places
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid loan amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to get the interest panel
    public JPanel getInterestPanel() {
        return interestPanel; // Return the current panel
    }

    // Main method for testing
    public static void main(String[] args) {
        JFrame frame = new JFrame("Interest Calculation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new interest().getInterestPanel());
        frame.setVisible(true);
    }
}
