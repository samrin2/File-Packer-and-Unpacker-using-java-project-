import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;

public class Template1 extends JFrame implements Serializable, ActionListener {
    JPanel _header;
    JPanel _content;
    JPanel _top;

    ClockLabel dayLabel;
    ClockLabel timeLabel;
    ClockLabel dateLabel;

    JButton minimize, exit;

    public Template() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);

        _top = new JPanel();
        _top.setBackground(Color.LIGHT_GRAY);
        _top.setLayout(null);
        getContentPane().add(_top, new GridBagConstraints(0, 0, 1, 1, 1, 5, GridBagConstraints.BASELINE, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        _header = new JPanel();
        _header.setLayout(null);
        _header.setBackground(Color.WHITE);
        getContentPane().add(_header, new GridBagConstraints(0, 1, 1, 1, 1, 20, GridBagConstraints.BASELINE, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        _content = new JPanel();
        _content.setLayout(null);
        _content.setBackground(new Color(0, 50, 120));
        JScrollPane jsp = new JScrollPane(_content, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        getContentPane().add(jsp, new GridBagConstraints(0, 2, 1, 1, 1, 75, GridBagConstraints.BASELINE, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        setTitle("Marvellous Packer-Unpacker");

        Clock();
        CloseAndMin();
    }

    void CloseAndMin() {
        minimize = new JButton("-");
        minimize.setBackground(Color.LIGHT_GRAY);
        minimize.setBounds(Frame.MAXIMIZED_HORIZ, 0, 45, 20);

        exit = new JButton("X");
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setBackground(Color.LIGHT_GRAY);
        exit.setHorizontalTextPosition(0);
        exit.setBounds(Frame.MAXIMIZED_HORIZ + 45, 0, 45, 20);

        _top.add(minimize);
        _top.add(exit);

        exit.addActionListener(this);
        minimize.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            this.setVisible(false);
            System.exit(0);
        }
        if (ae.getSource() == minimize) {
            setState(Frame.ICONIFIED);
        }
    }

    void Clock() {
        dateLabel = new ClockLabel("date");
        timeLabel = new ClockLabel("time");
        dayLabel = new ClockLabel("day");

        dateLabel.setForeground(Color.BLUE);
        timeLabel.setForeground(Color.BLUE);
        dayLabel.setForeground(Color.BLUE);
        dayLabel.setFont(new Font("Century", Font.BOLD, 15));
        dayLabel.setBounds(700, 10, 200, 100);
        dateLabel.setFont(new Font("Century", Font.BOLD, 15));
        dateLabel.setBounds(800, -40, 200, 100);
        timeLabel.setFont(new Font("Century", Font.BOLD, 15));
        timeLabel.setBounds(760, -15, 200, 100);

        _header.add(dateLabel);
        _header.add(timeLabel);
        _header.add(dayLabel);
    }

    void ClockHome() {
        dateLabel = new ClockLabel("date");
        timeLabel = new ClockLabel("time");
        dayLabel = new ClockLabel("day");

        dateLabel.setForeground(Color.BLUE);
        timeLabel.setForeground(Color.BLUE);
        dayLabel.setForeground(Color.BLUE);
        dayLabel.setFont(new Font("Century", Font.BOLD, 15));
        dayLabel.setBounds(200, 20, 200, 100);
        dateLabel.setFont(new Font("Century", Font.BOLD, 15));
        dateLabel.setBounds(300, -40, 200, 100);

        timeLabel.setFont(new Font("Century", Font.BOLD, 15));
        timeLabel.setBounds(260, -10, 200, 100);

        _header.add(dateLabel);
        _header.add(timeLabel);
        _header.add(dayLabel);
    }

    // Main method
    public static void main(String[] args) {
        // Create an instance of Template
        Template template = new Template();
        // Set the size of the frame
        template.setSize(800, 600);
        // Make the frame visible
        template.setVisible(true);
    }
}
