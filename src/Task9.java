import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q9 {
    private JFrame frame;
    private JPanel panel;
    private JProgressBar progressBar;
    private JButton startButton;
    private JButton resetButton;
    private Timer timer;
    private int progressValue;

    public void createProgressBarApp() {
        panel = new JPanel();
        progressBar = new JProgressBar(0, 100);
        startButton = new JButton("Start");
        resetButton = new JButton("Reset");
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (progressValue < 100) {
                    progressValue++;
                    progressBar.setValue(progressValue);
                } else {
                    ((Timer) e.getSource()).stop();
                    startButton.setEnabled(true);
                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                resetButton.setEnabled(true);
                progressValue = 0;
                progressBar.setValue(progressValue);
                timer.start();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(true);
                resetButton.setEnabled(false);
                timer.stop();
                progressValue = 0;
                progressBar.setValue(progressValue);
            }
        });

        resetButton.setEnabled(false);
        panel.add(progressBar);
        panel.add(startButton);
        panel.add(resetButton);

        //Frame
        frame = new JFrame("Progress Bar App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setVisible(true);
    }
}