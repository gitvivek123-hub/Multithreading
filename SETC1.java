/*a) Write a program that simulates a traffic light. The program lets the user select one of
three lights: red, yellow, or green with radio buttons. On selecting a button, an
appropriate message with “stop” or “ready” or “go”should appear above the buttons in
a selected color. Initially there is no message shown.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLight extends JFrame implements ActionListener {
    JLabel label;
    JRadioButton red, yellow, green;

    TrafficLight() {
        label = new JLabel("", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        red = new JRadioButton("Red");
        yellow = new JRadioButton("Yellow");
        green = new JRadioButton("Green");

        ButtonGroup bg = new ButtonGroup();
        bg.add(red); bg.add(yellow); bg.add(green);

        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);

        add(label, BorderLayout.NORTH);

        JPanel p = new JPanel();
        p.add(red); p.add(yellow); p.add(green);
        add(p, BorderLayout.CENTER);

        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (red.isSelected()) {
            label.setText("STOP");
            label.setForeground(Color.RED);
        } else if (yellow.isSelected()) {
            label.setText("READY");
            label.setForeground(Color.ORANGE);
        } else {
            label.setText("GO");
            label.setForeground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}
