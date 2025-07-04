import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro {
    private JPanel mainPanel;
    private JLabel label1;
    private JProgressBar progressBar1;
    private JFrame frame;

    public Intro() {
        // Create the frame
        frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Set the size of the frame
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create the main panel and set its layout
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.CYAN); // Set the background color to turquoise

        // Create the label for the bank title
        label1 = new JLabel("KZN BANKS", JLabel.CENTER);
        label1.setFont(new Font("Stencil", Font.BOLD, 36));
        label1.setForeground(Color.BLACK); // Set label text color to black

        // Create the progress bar
        progressBar1 = new JProgressBar();
        progressBar1.setIndeterminate(true); // Set progress bar to indeterminate mode
        progressBar1.setString("Loading...");
        progressBar1.setStringPainted(true); // Display string on the progress bar

        // Add components to the main panel
        mainPanel.add(label1, BorderLayout.CENTER);
        mainPanel.add(progressBar1, BorderLayout.SOUTH);

        // Add the main panel to the frame
        frame.add(mainPanel);
        frame.setVisible(true); // Show the frame

        // Simulate loading for 2 minutes
        Timer timer = new Timer(120000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the intro form
                new Menu(); // Open the Menu form
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        // Run the intro form
        SwingUtilities.invokeLater(Intro::new);
    }
}
