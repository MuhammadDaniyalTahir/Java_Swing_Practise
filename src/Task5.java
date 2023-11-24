import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Q5 extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private JButton prevButton;
    private JButton nextButton;
    private int currentImageIndex;
    private File[] imageFiles;

    public void createImageViewer() {
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        //Opening File
        File directory = new File("D:\\FAST-NUCES l215845\\5th Semester\\----------Extras----------\\Programming Fundamentals\\Assignments\\Assignment-2\\Extras\\Images");
        imageFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        if (imageFiles != null && imageFiles.length > 0) {
            currentImageIndex = 0;
            displayImage(currentImageIndex);
        } else {
            JOptionPane.showMessageDialog(this, "No images found in the directory.");
            System.exit(0);
        }

        //Frame
        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
        setTitle("Image Gallery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
    }

    private void displayImage(int index) {
        if (index >= 0 && index < imageFiles.length) {
            try {
                Image img = ImageIO.read(imageFiles[index]);
                Image scaledImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showPreviousImage() {
        if (currentImageIndex > 0) {
            currentImageIndex--;
            displayImage(currentImageIndex);
        }
    }

    private void showNextImage() {
        if (currentImageIndex < imageFiles.length - 1) {
            currentImageIndex++;
            displayImage(currentImageIndex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "Previous")) {
            showPreviousImage();
        } else {
            showNextImage();
        }
    }
}