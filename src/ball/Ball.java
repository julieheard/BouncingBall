package ball;

/**
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends JPanel {

    int x = 200, y = 250;
    int width = 50, height = 50;
    int dx = 1, dy = 1;

    java.util.Timer move; //making the instance of Timer class 
    static JFrame frame;

    Ball() {
        frame = new JFrame("Football by Tom and Dullah!");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        move = new java.util.Timer();

        move.scheduleAtFixedRate(new TimerTask() //to run the function at a fixed interval, @5 milliseconds
        {
            public void run() { // to make the ball act on collision

                if (y < 0) {
                    dy = 6;
                }
                if (y >= getHeight() - 118) {
                    dy = -3;
                }

//to make the ball move
                y += dy;

                repaint();

            }
        }, 0, 20
        );

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g); //painting the panel

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 900, 600);

        g.setColor(Color.GREEN);
        g.fillRect(0, 500, 900, 150);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //improving the quality

        g2d.fillOval(x, y, width, height);
        g2d.setColor(Color.white);//placing the oval 
//draw the sky

    }

    public static void main(String[] args) {
        Ball ball = new Ball();

        frame.add(ball);

    }
}
