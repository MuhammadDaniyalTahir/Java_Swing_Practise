import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Q7 {
    private JFrame frame;
    private JPanel drawingPanel;
    private JButton lineButton;
    private JButton rectangleButton;
    private JButton ellipseButton;
    private int currentShape = 0;
    private Point startPoint;
    private Point endPoint;

    public void createDrawingProgram() {
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (startPoint != null && endPoint != null) {
                    g.setColor(Color.BLACK);
                    if (currentShape == 0) {
                        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                    } else if (currentShape == 1) {
                        g.drawRect(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y),
                                Math.abs(startPoint.x - endPoint.x), Math.abs(startPoint.y - endPoint.y));
                    } else if (currentShape == 2) {
                        g.drawOval(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y),
                                Math.abs(startPoint.x - endPoint.x), Math.abs(startPoint.y - endPoint.y));
                    }
                }
            }
        };
        lineButton = new JButton("Line");
        rectangleButton = new JButton("Rectangle");
        ellipseButton = new JButton("Ellipse");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(lineButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(ellipseButton);

        //Action Listeners
        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 0;
            }
        });

        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 1;
            }
        });

        ellipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 2;
            }
        });

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                endPoint = e.getPoint();
                drawingPanel.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endPoint = e.getPoint();
                drawingPanel.repaint();
            }
        });

        drawingPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                drawingPanel.repaint();
            }
        });

        //Frame
        frame = new JFrame("Drawing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(drawingPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}