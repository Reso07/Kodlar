package JavaCourse;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends Frame {
    public Window(String title) throws HeadlessException {
        super(title);
        setSize(600,600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font font1 = new Font("SansSerif",Font.BOLD,25);
        g.setFont(font1);g.setColor(new Color(234999999));
        g.drawString("HELLO THIS IS MY WINDOW",500,500);
        g.drawOval(400,400,200,200);
    }
}
