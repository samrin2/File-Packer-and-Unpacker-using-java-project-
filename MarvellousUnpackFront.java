//MarvellousUnpackFront.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InvalidFileException extends Exception {
    public InvalidFileException(String str) {
        super(str);
    }
}

public class MarvellousUnpackFront extends Template implements ActionListener 
{
    JButton SUBMIT, PREVIOUS;
    JLabel label1, label2, title;
    final JTextField text1;

    public MarvellousUnpackFront() {
        setDefaultOperation(JFrame.DISPOSE_ON_CLOSE);

        title = new JLabel("Unpacking Portal");
        Dimension size = title.getPreferredSize();
        title.setBounds(40, 50, size.width + 60, size.height);
        title.setFont(new Font("Century", Font.BOLD, 17));
        title.setForeground(Color.BLUE);

        label1 = new JLabel();
        label1.setText("File Name");
        label1.setForeground(Color.WHITE);
        label1.setBounds(350, 50, size.width, size.height);

        text1 = new JTextField(15);
        Dimension tsize = text1.getPreferredSize();
        text1.setBounds(500, 50, tsize.width, tsize.height);
        text1.setToolTipText("Enter name of directory");

        SUBMIT = new JButton("Extract Here");
        Dimension bsize = SUBMIT.getPreferredSize();
        SUBMIT.setBounds(500, 200, bsize.width, bsize.height);
        SUBMIT.addActionListener(this);

        _header.add(title);
        _content.add(label1);
        _content.add(text1);
        _content.add(SUBMIT);

        this.setSize(1000, 400);
        this.setResizable(false);
        this.setVisible(true);
        text1.requestFocusInWindow();
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == exitButton) {
            this.setVisible(false);
            System.exit(0);
        }
        if (ae.getSource() == minimizeButton) {
            this.setState(Frame.ICONIFIED);
        }
        if (ae.getSource() == SUBMIT) {
            try {
                MarvellousUnpack obj = new MarvellousUnpack(text1.getText());
                this.dispose();
                NextPage t = new NextPage("admin");
            } catch (InvalidFileException e) {
                this.setVisible(false);
                this.dispose();

                JOptionPane.showMessageDialog(this, "Invalid Packed File", "Error", JOptionPane.ERROR_MESSAGE);

                NextPage t = new NextPage("MarvellousAdmin");
            }
        }
        if (ae.getSource() == PREVIOUS) {
            this.setVisible(false);
            this.dispose();
            NextPage t = new NextPage("admin");
        }
    }
}
