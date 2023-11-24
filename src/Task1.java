import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q1 extends JFrame implements ActionListener {
    private JLabel label;
    private JButton button;
    static int x = 0;

    public void createGUI() {
        setTitle("Incrementing");
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("-");
        button = new JButton("Press to Increment");
        button.addActionListener(this);
        add(label);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText(String.valueOf(++x));
    }
}