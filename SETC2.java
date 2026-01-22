/*b) Write a program to create a thread for moving a ball inside a panel vertically. The ball
should be created when the user clicks on the start button.*/
import javax.swing.*;
import java.awt.*;

class BallPanel extends JPanel implements Runnable {
    int y = 0;

    public void run() {
        while (true) {
            y += 5;
            if (y > getHeight()) y = 0;
            repaint();
            try { Thread.sleep(100); } catch (Exception e) {}
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(100, y, 30, 30);
    }
}

public class MovingBall {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        BallPanel panel = new BallPanel();

        JButton btn = new JButton("Start");
        btn.addActionListener(e -> new Thread(panel).start());

        f.add(panel);
        f.add(btn, BorderLayout.SOUTH);
        f.setSize(300,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
