package example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class countdownTimer extends JFrame{
        private static final int SECONDS_IN_MINUTE = 60;
        private static final int COUNTDOWN_MINUTES = 20;
        private static final int COUNTDOWN_SECONDS = COUNTDOWN_MINUTES * SECONDS_IN_MINUTE;


        private final JLabel countdownLabel;
        private Timer timer;
        private int countdown;

        public countdownTimer() {
            setTitle("Countdown Timer");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(200, 150);
            setLayout(new FlowLayout());

            countdownLabel = new JLabel(formatTime(COUNTDOWN_SECONDS));
            countdownLabel.setFont(new Font("Arial", Font.BOLD, 24));
            add(countdownLabel);

            JButton restartButton = new JButton("Restart");
            restartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopTimer();
                    resetTimer();
                    startTimer();
                }
            });
            add(restartButton);

            resetTimer();
        }

        private void resetTimer() {
            countdown = COUNTDOWN_SECONDS;
            countdownLabel.setText(formatTime(countdown));
        }

        private String formatTime(int seconds) {
            int minutes = seconds / SECONDS_IN_MINUTE;
            int remainingSeconds = seconds % SECONDS_IN_MINUTE;
            return String.format("%02d:%02d", minutes, remainingSeconds);
        }

        private void playSound() {

            Toolkit.getDefaultToolkit().beep();
        }

        public void startTimer() {
            ActionListener timerListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (countdown > 0) {
                        countdown--;
                        countdownLabel.setText(formatTime(countdown));
                    } else {
                        playSound();
                        stopTimer();
                    }
                }
            };
            timer = new Timer(1000, timerListener);
            timer.start();
        }

        public void stopTimer() {
            timer.stop();
        }
    }

