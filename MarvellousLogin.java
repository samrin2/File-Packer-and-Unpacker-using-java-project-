//MarvellousMain.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class MarvellousLogin extends Template implements ActionListener, Runnable {
    JButton SUBMIT;
    JLabel label1, label2, label3, TopLabel;
    final JTextField text1, text2;
    private static int attempt = 3;

    MarvellousLogin() {
        TopLabel = new JLabel();
        TopLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TopLabel.setText("Marvellous Packer unpacker : Login");
        TopLabel.setForeground(Color.BLUE);

        Dimension topSize = TopLabel.getPreferredSize();
        TopLabel.setBounds(50, 40, topSize.width, topSize.height);
        header.add(TopLabel);

        label1 = new JLabel();
        label1.setText("Username:");
        label1.setForeground(Color.WHITE);

        Dimension size = label1.getPreferredSize();

        label1.setBounds(50, 135, size.width, size.height);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        text1 = new JTextField();
        text1.setToolTipText("Enter USERNAME");

        label2 = new JLabel();
        label2.setText("Password:");
        label2.setBounds(50, 175, size.width, size.height);
        label2.setForeground(Color.WHITE);
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        text2 = new JPasswordField(15);
        text2.setBounds(200, 175, size.width, size.height);
        text2.setToolTipText("ENTER PASSWORD");

        label3 = new JLabel();
        label3.setText("");
        label3.setForeground(Color.RED);

        Dimension label3Size = label3.getPreferredSize();
        label3.setBounds(50, 250, label3Size.width, label3Size.height);

        SUBMIT = new JButton("SUBMIT");
        SUBMIT.setHorizontalAlignment(SwingConstants.CENTER);

        Dimension buttonSize = SUBMIT.getPreferredSize();
        SUBMIT.setBounds(50, 220, buttonSize.width, buttonSize.height);

        content.add(label1);
        content.add(text1);

        content.add(label2);
        content.add(text2);

        content.add(label3);
        content.add(SUBMIT);

        pack();
        validate();

        ClockHome();
        setVisible(true);
        this.setSize(500, 500);
        this.setResizable(false);
        setLocationRelativeTo(null);
        SUBMIT.addActionListener(this);
    }

    public boolean validate(String username, String password) {
        return username.length() >= 8 && password.length() >= 8;
    }

    public void actionPerformed(ActionEvent ae) {
        String value1 = text1.getText();
        String value2 = text2.getText();

        if (ae.getSource() == exit) {
            this.setVisible(false);
            System.exit(0);
        }
        if (ae.getSource() == minimize) {
            this.setState(Frame.ICONIFIED);
        }
        if (ae.getSource() == SUBMIT) {
            if (!validate(value1, value2)) {
                text1.setText("");
                text2.setText("");
                JOptionPane.showMessageDialog(this, "Short username", "Marvellous Packer Unpacker", JOptionPane.ERROR_MESSAGE);
            }
            if (value1.equals("MarvellousAdmin") && value2.equals("MarvellousAdmin")) {
                NextPage page = new NextPage(value1);
                this.setVisible(false);
                page.pack();
                page.setVisible(true);
                page.setSize(500, 500);
            } else {
                attempt--;
                if (attempt == 0) {
                    JOptionPane.showMessageDialog(this, "Number of attempts finished", "Marvellous Packer Unpacker", JOptionPane.ERROR_MESSAGE);
                    this.dispose();
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(this, "Incorrect login or password", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void run() {
        while (true) {
            if (text2.isFocusOwner()) {
                if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
                    text2.setToolTipText("Warning: CAPS LOCK is on");
                } else {
                    text2.setToolTipText("");
                }

                if (text2.getText().length() < 8) {
                    label3.setText("Weak Password");
                } else {
                    label3.setText("");
                }
            }
        }
    }

    class MarvellousMain {
        public static void main(String arg[]) {
            try {
                MarvellousLogin frame = new MarvellousLogin();
                frame.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}

class ClockLabel extends JLabel implements ActionListener {
    String type;
    SimpleDateFormat sdf;

    public ClockLabel(String type) {
        this.type = type;
        setForeground(Color.GREEN);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM dd yyyy");
                setFont(new Font("sans-serif", Font.PLAIN, 12));
                setHorizontalAlignment(SwingConstants.LEFT);
                break;
           