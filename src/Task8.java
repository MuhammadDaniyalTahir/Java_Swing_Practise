import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Q8 extends JFrame implements ActionListener {

    private static String username = "l215845";
    private static String password = "147147";
    private JPanel p1;
    private JLabel l1;
    private JLabel l2;
    private JTextField uName;
    private JPasswordField pass;
    private JButton login;

    public void createLoginPage() {
        l1 = new JLabel("Username: ");
        l2 = new JLabel("Password: ");
        uName = new JTextField(20);
        pass = new JPasswordField(20);
        JPanel jp1 = new JPanel(new FlowLayout());
        jp1.add(l1);
        jp1.add(uName);
        JPanel jp2 = new JPanel(new FlowLayout());
        jp2.add(l2);
        jp2.add(pass);
        login = new JButton("Login");
        login.addActionListener(this);
        p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.add(jp1);
        p1.add(jp2);
        p1.add(login);

        //Frame
        setLayout(new GridLayout(3, 1));
        add(new JPanel());
        add(p1);
        add(new JPanel());
        setTitle("Login Page");
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char[] passwordChars = pass.getPassword();
        String st = new String(passwordChars);
        if (Objects.equals(uName.getText(), username) && st.equals(password)) {
            JOptionPane.showMessageDialog(this, "Login Successful!\n");
            System.exit(0);
        } else {
            if (!Objects.equals(uName.getText(), username) && !st.equals(password)) {
                JOptionPane.showMessageDialog(this, "Incorrect Username and Password!", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (!Objects.equals(uName.getText(), username)) {
                JOptionPane.showMessageDialog(this, "Incorrect Username!", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (!st.equals(password)) {
                JOptionPane.showMessageDialog(this, "Incorrect Password!", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}