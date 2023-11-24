import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Q10 {
    private JFrame frame = new JFrame();
    private JPanel calendarPanel;
    private JTextArea eventTextArea;
    private JButton prevMonthButton;
    private JButton nextMonthButton;
    private Date currentDate;

    public void createMonthlyCalendarApp() {
        calendarPanel = new JPanel(new GridLayout(0, 7));
        eventTextArea = new JTextArea();
        prevMonthButton = new JButton("Previous Month");
        nextMonthButton = new JButton("Next Month");
        currentDate = new Date();
        updateCalendar();

        //Action Listeners
        prevMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDate = addMonths(currentDate, -1);
                updateCalendar();
            }
        });

        nextMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDate = addMonths(currentDate, 1);
                updateCalendar();
            }
        });

        //Frame
        frame.setTitle("Monthly Calender");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(calendarPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(eventTextArea), BorderLayout.CENTER);
        frame.add(prevMonthButton, BorderLayout.WEST);
        frame.add(nextMonthButton, BorderLayout.EAST);
        frame.setVisible(true);
    }

    private void updateCalendar() {
        calendarPanel.removeAll();
        eventTextArea.setText("");
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        frame.setTitle("Monthly Calendar - " + sdf.format(currentDate));
        CalendarUtil calUtil = new CalendarUtil(currentDate);

        for (int i = 0; i < calUtil.getDaysInMonth(); i++) {
            JButton dayButton = new JButton(Integer.toString(i + 1));
            int day = i + 1;
            dayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eventTextArea.setText("Events for " + day + "/" + calUtil.getMonth() + "/" + calUtil.getYear() + ":\n\n");
                }
            });
            calendarPanel.add(dayButton);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private Date addMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    class CalendarUtil {
        private int year;
        private int month;
        private Calendar calendar;

        public CalendarUtil(Date date) {
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) + 1;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDaysInMonth() {
            int daysInMonth = 0;
            switch (month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    daysInMonth = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    daysInMonth = 30;
                    break;
                case 2:
                    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                        daysInMonth = 29; // Leap year
                    } else {
                        daysInMonth = 28;
                    }
                    break;
            }
            return daysInMonth;
        }
    }

}