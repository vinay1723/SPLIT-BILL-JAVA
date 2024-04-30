import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CircularImagePanel extends JPanel {
    private Image image;
    public  Color c = new Color(0, 0, 0) ;
    
    public CircularImagePanel(String path) {
        // Load the image
        try {

            File inputfile = new File(path);
            image = ImageIO.read(inputfile); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBackground(c);
        setOpaque(false);
        
        // Set panel size
        setPreferredSize(new Dimension(70, 70));
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d  = (Graphics2D) g.create();
        
        // Clear the previous drawing
        g2d.clearRect(0, 0, 75, 75);
        g2d.setColor(c); // Transparent color
        //  g2d.setColor(new Color(0, 0, 0,0)); // Transparent color
        g2d.fillRect(0, 0, 75, 75);
        // Create a circular clipping area
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 75, 75);
        g2d.setClip(circle);
        
        // Draw the image
        if (image != null) {
            g2d.drawImage(image, 0, 0, 75, 75, null);
           
        }
        
        // Dispose Graphics2D object
        g2d.dispose();
    }
    
    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         JFrame frame = new JFrame("Circular Image Panel");
    //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //         frame.getContentPane().add(new CircularImagePanel());
    //         frame.pack();
    //         frame.setLocationRelativeTo(null);
    //         frame.setVisible(true);
    //     });
    // }
}

