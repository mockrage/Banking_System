import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer {
    private JPanel newCustomerPanel;
    private JTextField textFieldLastName;
    private JTextField textFieldFirstName; // Field for first name
    private JLabel firstNameLabel; // Declare firstNameLabel
    private JLabel lastNameLabel; // Declare lastNameLabel
    private JLabel genderLabel; // Declare genderLabel
    private JLabel dobLabel; // Declare dobLabel
    private JLabel addressLabel; // Declare addressLabel
    private JLabel phoneNumberLabel; // Declare phoneNumberLabel
    private JLabel idNumberLabel; // Declare idNumberLabel
    private JComboBox<String> comboBoxGender;
    private JSpinner spinnerDOB;
    private JTextField textFieldAddress;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldIDNumber;
    private JButton buttonCreate;

    public NewCustomer() {
        // Create the panel
        newCustomerPanel = new JPanel();
        newCustomerPanel.setLayout(new GridLayout(8, 2)); // 8 rows, 2 columns

        // Initialize labels and fields
        lastNameLabel = new JLabel("Last Name:");
        textFieldLastName = new JTextField();

        firstNameLabel = new JLabel("First Name:"); // Initialize firstNameLabel
        textFieldFirstName = new JTextField();

        genderLabel = new JLabel("Gender:"); // Initialize genderLabel
        comboBoxGender = new JComboBox<>(new String[]{"Male", "Female", "Other"});

        dobLabel = new JLabel("Date of Birth:"); // Initialize dobLabel
        spinnerDOB = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerDOB, "yyyy-MM-dd");
        spinnerDOB.setEditor(dateEditor);

        addressLabel = new JLabel("Address:"); // Initialize addressLabel
        textFieldAddress = new JTextField();

        phoneNumberLabel = new JLabel("Phone Number:"); // Initialize phoneNumberLabel
        textFieldPhoneNumber = new JTextField();

        idNumberLabel = new JLabel("ID Number:"); // Initialize idNumberLabel
        textFieldIDNumber = new JTextField();

        // Add labels and fields to the panel
        newCustomerPanel.add(lastNameLabel);
        newCustomerPanel.add(textFieldLastName);

        newCustomerPanel.add(firstNameLabel); // Add firstNameLabel to the panel
        newCustomerPanel.add(textFieldFirstName);

        newCustomerPanel.add(genderLabel); // Add genderLabel to the panel
        newCustomerPanel.add(comboBoxGender);

        newCustomerPanel.add(dobLabel); // Add dobLabel to the panel
        newCustomerPanel.add(spinnerDOB);

        newCustomerPanel.add(addressLabel); // Add addressLabel to the panel
        newCustomerPanel.add(textFieldAddress);

        newCustomerPanel.add(phoneNumberLabel); // Add phoneNumberLabel to the panel
        newCustomerPanel.add(textFieldPhoneNumber);

        newCustomerPanel.add(idNumberLabel); // Add idNumberLabel to the panel
        newCustomerPanel.add(textFieldIDNumber);

        // Create button
        buttonCreate = new JButton("Create");
        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCustomer();
            }
        });
        newCustomerPanel.add(buttonCreate);
    }

    private void createCustomer() {
        // Generate a random account number
        Random random = new Random();
        int accountNumber = 100000 + random.nextInt(900000); // Generates a 6-digit account number

        // Show success message
        JOptionPane.showMessageDialog(newCustomerPanel,
                "Customer created successfully!\nAccount Number: " + accountNumber,
                "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear the fields for the next entry
        clearFields();
    }

    private void clearFields() {
        textFieldLastName.setText("");
        textFieldFirstName.setText("");
        comboBoxGender.setSelectedIndex(0); // Reset to first gender option
        spinnerDOB.setValue(new java.util.Date()); // Reset to current date
        textFieldAddress.setText("");
        textFieldPhoneNumber.setText("");
        textFieldIDNumber.setText("");
    }

    public JPanel getNewCustomerPanel() {
        return newCustomerPanel;
    }

    public static void main(String[] args) {
        // Create the frame to hold the New Customer JPanel
        JFrame frame = new JFrame("New Customer Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create an instance of the NewCustomer class and add its panel to the frame
        NewCustomer newCustomerForm = new NewCustomer();
        frame.add(newCustomerForm.getNewCustomerPanel());

        // Display the frame
        frame.setVisible(true);
    }
}
