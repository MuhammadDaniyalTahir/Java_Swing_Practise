import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q2 extends JFrame implements ActionListener {
    private JPanel p1;
    private JPanel p2;
    private JLabel sign;
    private JLabel equal;
    private JTextField num1;
    private JTextField num2;
    private JTextField result;
    private JButton add;
    private JButton sub;
    private JButton mul;
    private JButton div;

    static int x = 0;

    public void createGUI() {
        sign = new JLabel(" ? ");
        equal = new JLabel(" = ");
        num1 = new JTextField(10);
        num2 = new JTextField(10);
        result = new JTextField(10);
        add = new JButton("+");
        add.addActionListener(this::actionPerformed);
        sub = new JButton("-");
        sub.addActionListener(this::actionPerformed);
        mul = new JButton("x");
        mul.addActionListener(this::actionPerformed);
        div = new JButton("/");
        div.addActionListener(this::actionPerformed);
        p1 = new JPanel(new FlowLayout());
        p1.add(num1);
        p1.add(sign);
        p1.add(num2);
        p1.add(equal);
        p1.add(result);
        p2 = new JPanel(new GridLayout(2, 2));
        p2.add(add);
        p2.add(sub);
        p2.add(mul);
        p2.add(div);

        //Frame
        setTitle("Calculator");
        add(p1);
        add(p2);
        setVisible(true);
        setLayout(new GridLayout(2, 1));
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "+" -> add();
            case "-" -> sub();
            case "x" -> mul();
            case "/" -> div();
        }
    }

    public void add() {
        sign.setText(" + ");
        result.setText(String.valueOf(Double.parseDouble(num1.getText()) + Double.parseDouble(num2.getText())));
    }

    public void sub() {
        sign.setText(" - ");
        result.setText(String.valueOf(Double.parseDouble(num1.getText()) - Double.parseDouble(num2.getText())));
    }

    public void mul() {
        sign.setText(" x ");
        result.setText(String.valueOf(Double.parseDouble(num1.getText()) * Double.parseDouble(num2.getText())));
    }

    public void div() {
        sign.setText(" / ");
        result.setText(String.valueOf(Double.parseDouble(num1.getText()) / Double.parseDouble(num2.getText())));
    }
}