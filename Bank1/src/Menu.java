import javax.swing.*;
import java.awt.*;

public class Menu {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JLabel label2; // Declare label2 for the title
    private BankAccount bankAccount;

    public Menu() {

        bankAccount = new BankAccount("123456", "Mockrage Chomusina", 100.00);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.CYAN); // Set the background color to turquoise

        // Initialize label2
        label2 = new JLabel("Main Menu", JLabel.CENTER); // Set text and alignment
        label2.setFont(new Font("Stencil", Font.BOLD, 24)); // Set font for label2
        label2.setForeground(Color.BLACK); // Set text color to black
        mainPanel.add(label2, BorderLayout.NORTH); // Add label to the top

        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.setBackground(Color.BLACK); // Set the background color of the tabbed pane
        tabbedPane.setForeground(Color.white); // Set the text color of the tabs to turquoise

        // Add tabs for different forms
        tabbedPane.addTab("New Customer", new NewCustomer().getNewCustomerPanel());
        tabbedPane.addTab("Open Account", new OpenAccount().getOpenAccountPanel());
        tabbedPane.addTab("Deposit", new Deposit().getDepositPanel());
        tabbedPane.addTab("Withdraw", new Withdraw().getWithdrawPanel());
        tabbedPane.addTab("Transfer Money", new Transfer().getTransferPanel());
        tabbedPane.addTab("Check Balance", new Balance(bankAccount).getCheckBalancePanel());
        tabbedPane.addTab("History", new History().getHistoryPanel());
        tabbedPane.addTab("Repay Loan", new Repay().getRepayPanel());
        tabbedPane.addTab("Interest", new interest().getInterestPanel());
        tabbedPane.addTab("Exit", new JPanel()); // Exit tab

        // Add an action listener for the Exit tab
        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == tabbedPane.getTabCount() - 1) {
                System.exit(0); // Exit the application
            }
        });

        mainPanel.add(tabbedPane, BorderLayout.CENTER);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Banking Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the frame
        Menu menu = new Menu();
        frame.add(menu.getMainPanel());
        frame.setVisible(true);
    }
}
