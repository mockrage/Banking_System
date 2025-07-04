import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class History {
    private JPanel HistoryPanel; // Panel to be used in the main application
    private DefaultTableModel tableModel;
    private JTable historyTable;

    public History() {
        // Create the main panel
        HistoryPanel = new JPanel(new BorderLayout());

        // Column names for the table
        String[] columnNames = {"Date", "Time", "Transaction Type", "Transferred Amount", "Withdrawn Amount", "Deposited Amount"};

        // Initialize the table model
        tableModel = new DefaultTableModel(columnNames, 0);
        historyTable = new JTable(tableModel);

        // Set the custom cell renderer
        historyTable.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14)); // Header font
        historyTable.setFont(new Font("Times New Roman", Font.PLAIN, 12)); // Data font

        // Create a JScrollPane to hold the table
        JScrollPane scrollPane = new JScrollPane(historyTable);
        HistoryPanel.add(scrollPane, BorderLayout.CENTER);

        // Sample data for demonstration
        addTransaction("Deposit", "100", "0", "100");
        addTransaction("Withdrawal", "0", "50", "0");
        addTransaction("Transfer", "200", "0", "0");
    }

    // Method to add a transaction to the table
    public void addTransaction(String transactionType, String transferredAmount, String withdrawnAmount, String depositedAmount) {
        // Get the current date and time
        String date = formatDate(new Date());
        String time = formatTime(new Date());

        // Add a new row to the table model
        tableModel.addRow(new Object[]{date, time, transactionType, transferredAmount, withdrawnAmount, depositedAmount});
    }

    // Utility method to format the date
    private String formatDate(Date date) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    // Utility method to format the time
    private String formatTime(Date date) {
        return new java.text.SimpleDateFormat("HH:mm:ss").format(date);
    }

    // Method to get the panel containing the history table
    public JPanel getHistoryPanel() {
        return HistoryPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            History historyForm = new History();
            JFrame frame = new JFrame("Transaction History");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.add(historyForm.getHistoryPanel()); // Add the history panel to the frame
            frame.setVisible(true); // Show the history form
        });
    }
}
