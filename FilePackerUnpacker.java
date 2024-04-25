import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FilePackerUnpacker extends JFrame {
    private JTextField usernameField, passwordField;
    private JButton loginButton, packButton, unpackButton;
    private JTextArea logTextArea;

    public FilePackerUnpacker() {
        setTitle("File Packer Unpacker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400); // Increased window size
        setLocationRelativeTo(null);

        // Set window background color to blue
        getContentPane().setBackground(Color.BLUE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());
        panel.add(loginButton);

        packButton = new JButton("Pack File");
        packButton.setEnabled(false);
        packButton.addActionListener(new PackButtonListener());
        panel.add(packButton);

        unpackButton = new JButton("Unpack File");
        unpackButton.setEnabled(false);
        unpackButton.addActionListener(new UnpackButtonListener());
        panel.add(unpackButton);

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(logTextArea), BorderLayout.CENTER);
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Perform login validation (e.g., check username and password)
            if (isValidLogin(username, password)) {
                logTextArea.append("Login successful!\n");
                packButton.setEnabled(true);
                unpackButton.setEnabled(true);
            } else {
                logTextArea.append("Invalid username or password!\n");
            }
        }

        private boolean isValidLogin(String username, String password) {
            // Dummy validation logic (replace with actual validation)
            return username.equals("admin") && password.equals("admin");
        }
    }

    private class PackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform file packing logic
            logTextArea.append("Packing file...\n");
        }
    }

    private class UnpackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform file unpacking logic
            logTextArea.append("Unpacking file...\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FilePackerUnpacker app = new FilePackerUnpacker();
            app.setVisible(true);
        });
    }
}
