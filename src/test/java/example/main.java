package example;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            countdownTimer timer = new countdownTimer();
            timer.setVisible(true);
            timer.startTimer();
        });
    }
}
