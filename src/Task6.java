import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q6 {
    private JFrame frame;
    private JPanel colorPanel;
    private JButton[] colorButtons;

    public void createColorPalette() {
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.PINK);
        frame.add(colorPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        String[] colorNames = {"Red", "Green", "Blue", "Yellow", "Cyan", "Pink"};
        colorButtons = new JButton[colorNames.length];
        for (int i = 0; i < colorNames.length; i++) {
            final Color color = getColorByName(colorNames[i]);
            colorButtons[i] = new JButton(colorNames[i]);
            colorButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    colorPanel.setBackground(color);
                }
            });
            buttonPanel.add(colorButtons[i]);
        }

        //Frame
        frame = new JFrame("Color Palette");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private Color getColorByName(String name) {
        switch (name) {
            case "Red":
                return Color.RED;
            case "Green":
                return Color.GREEN;
            case "Blue":
                return Color.BLUE;
            case "Yellow":
                return Color.YELLOW;
            case "Cyan":
                return Color.CYAN;
            case "Pink":
                return Color.PINK;
            default:
                return Color.BLACK;
        }
    }
}
