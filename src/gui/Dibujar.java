package gui;


import model.Marrazkia;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JComponent;

/**
 * Component for drawing !
 *
 * @author sylsau
 *
 */
public class Dibujar extends JComponent {
    
    private Image image; //la imagen que se guarda

    private Graphics2D g2; // declaracion de graficos
    
    private int currentX, currentY, oldX, oldY; // la x actual y la vieja
    
    public Dibujar() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // save coord x,y when mouse is pressed
                oldX = e.getX();
                oldY = e.getY();
                
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // coord x,y when drag mouse
                currentX = e.getX();
                currentY = e.getY();
                
                if (g2 != null) {
                    // draw line if g2 context not null
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    // refresh draw area to repaint
                    repaint();
                    // store current coords x,y as olds x,y
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }
    
    protected void paintComponent(Graphics g) {
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke((Integer) 5));

            // clear draw area
            clear();
        }
        
        g.drawImage(image, 0, 0, null);
    }

    // now we create exposed methods
    public void clear() {
        g2.setPaint(Color.white);
        // draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }
    
    
    public void save(Marrazkia m) {
        
        BufferedImage bufImage = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_RGB);
        this.paint(bufImage.createGraphics());
        
            try {

            ImageIO.write(bufImage, "png", new File("build/classes/img/" + m.getArgazkiIzena() + ".png"));
           // ImageIO.write(bufImage, "png", new File("src/img/" + m.getArgazkiIzena() + ".png"));

        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }
    
    public void anchura(Integer ancho) {
        g2.setStroke(new BasicStroke(ancho));
        
    }
    
    public void koloreaAldatu(Color c) {
        g2.setPaint(c);
    }
    
    public void borragoma (){
    g2.setPaint(Color.white);
    
    }
}
