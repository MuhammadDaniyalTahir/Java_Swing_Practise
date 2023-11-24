import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q3 extends JFrame implements ActionListener {
    private JTextField text;
    private JTable data;
    private DefaultTableModel model;

    public void createTODOList() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Work To Do"});
        data = new JTable(model);
        JScrollPane sp = new JScrollPane(data);
        JPanel body = new JPanel(new GridLayout(2, 1));
        body.add(sp);

        JLabel work = new JLabel("Add Work");
        text = new JTextField(30);
        JButton add = new JButton("Add");
        add.addActionListener(this);
        JPanel input = new JPanel(new FlowLayout());
        input.add(work);
        input.add(text);
        input.add(add);
        body.add(input);

        //Frame
        setTitle("TODO List");
        setVisible(true);
        setSize(500, 400);
        add(body);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (text.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Text Field Empty!\nAdd Some Text", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            model.addRow(new String[]{text.getText()});
            text.setText("");
            JOptionPane.showMessageDialog(this, "Work Added Successfully!\n");
        }
    }
}
