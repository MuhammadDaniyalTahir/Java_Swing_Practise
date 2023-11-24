import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q4 extends JFrame implements ActionListener {
    private JTextField t1;
    private JTextField t2;
    private JComboBox b1;
    private JComboBox b2;

    public void createConverter() {
        t1 = new JTextField(5);
        t2 = new JTextField(5);
        t2.setEditable(false);
        JButton ok = new JButton(" = ");
        ok.addActionListener(this);
        b1 = new JComboBox(new String[]{"Fahrenheit", "Celsius"});
        b2 = new JComboBox(new String[]{"Celsius", "Fahrenheit"});
        JPanel body = new JPanel(new FlowLayout());
        body.add(b1);
        body.add(t1);
        body.add(ok);
        body.add(t2);
        body.add(b2);

        //Frame
        setTitle("Temperature Converter");
        JPanel jp = new JPanel(new FlowLayout());
        setLayout(new BorderLayout());
        add(jp, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((String) b1.getSelectedItem() == (String) b2.getSelectedItem()) {
            JOptionPane.showMessageDialog(this, "Please Select Distinct Units!", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            double val = 0;
            if ((String) b1.getSelectedItem() == "Celsius") {
                val = Double.parseDouble(t1.getText());
                val = 5 / 9 * (val - 32);
                t2.setText(String.valueOf(val));
            } else {
                val = Double.parseDouble(t1.getText());
                val = (val * (9 / 5)) + 32;
                t2.setText(String.valueOf(val));
            }
        }
    }
}
