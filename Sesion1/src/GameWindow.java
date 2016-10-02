import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2/10/2016.
 */
public class GameWindow extends Frame {
    Image backgroundImage = null;
    Image planeImage1 = null;
    Image planeImage2 = null;
    private int planeX1 = 280;
    private int planeY1 = 350;
    private int planeX2 = 200;
    private int planeY2 = 350;

    public GameWindow(){
        this.setVisible(true);
        this.setSize(600, 400);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated");

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated");

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        planeX1 += 10;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        planeX1 -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        planeY1 -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY1 += 10;
                        repaint();
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");

            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + " , " + y);
                planeX2 = x;
                planeY2 = y;
                repaint();
            }
        });


        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            planeImage1 = ImageIO.read(new File("resources/plane3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            planeImage2 = ImageIO.read(new File("resources/plane2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        repaint();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, 600, 400, null );
        g.drawImage(planeImage1, planeX1, planeY1, 40, 30, null);
        g.drawImage(planeImage2, planeX2, planeY2, 40, 30, null);
    }
}
