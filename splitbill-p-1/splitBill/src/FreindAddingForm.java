import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FreindAddingForm {

   public static JFrame friendForm;
    File selectedFile;
    String selectedImage = null;  
       FreindAddingForm(){
         
         
        JPanel freindform = new JPanel(new FlowLayout(FlowLayout.CENTER,20,50));
        JPanel freindformsub = new JPanel(new FlowLayout(FlowLayout.CENTER,25,9));
        freindform.setBackground(new Color(33,37,41));
        freindform.setPreferredSize(new Dimension(500,350));
        freindformsub.setBackground(new Color(33,37,41));
        freindformsub.setPreferredSize(new Dimension(500,350));
        JPanel subPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
        subPanel1.setPreferredSize(new Dimension(425,50));
       JPanel subPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
       subPanel2.setPreferredSize(new Dimension(425,50));
       JPanel subPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
       subPanel3.setPreferredSize(new Dimension(425,50));
       subPanel1.setBackground(new Color(33,37,41));
       subPanel2.setBackground(new Color(33,37,41));
       subPanel3.setBackground(new Color(33,37,41));
        JTextField fname = new JTextField("name of your friend");
        JButton imagePath = new JButton("UploadImage");
        fname.setFont(new Font("SANS_SERIF",0,19));
        imagePath.setFont(new Font("SANS_SERIF",0,19));
        fname.setPreferredSize(new Dimension(245, 45));
        imagePath.setPreferredSize(new Dimension(245, 45));
        JLabel em = new JLabel("nnnnnnnnnnnnnnnnnnnnnn");
        em.setForeground(new Color(33,37,41));
        em.setFont(new Font("SANS_SERIF",0,20));
        JLabel name = new JLabel("FreindName");
        name.setFont(new Font("SANS_SERIF",0,20));
        name.setForeground(Color.cyan);
        JLabel path = new JLabel("ImagePath  ");
        path.setFont(new Font("SANS_SERIF",0,20));
        path.setForeground(Color.CYAN);
        JButton add = new JButton("add friend");
        add.setPreferredSize(new Dimension(130,40));
        add.setFont(new Font("SANS_SERIF",0,20));
        add.setBackground(Color.CYAN);
        add.setForeground(new Color(33,37,41));
        subPanel1.add(name);
        subPanel1.add(fname);
        subPanel2.add(path);
        subPanel2.add(imagePath);
        subPanel3.add(em);
        subPanel3.add(add);

        
        friendForm = new JFrame("ADD FREIND");
        friendForm.setLayout(new FlowLayout(FlowLayout.CENTER));
       freindformsub.add(subPanel1);
       freindformsub.add(subPanel2);
       freindformsub.add(subPanel3);
       freindform.add(freindformsub);
       friendForm.add(freindform);
    friendForm.setSize(500,300);
    friendForm.setLocationRelativeTo(null);
    friendForm.setBackground(new Color(33,37,41));
    friendForm.setVisible(true);
    friendForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    friendForm.setLayout(new BorderLayout());


     class MyListener implements ActionListener {
               
      public void actionPerformed(ActionEvent e) {
      
         String name = fname.getText();
         JFileChooser fc = new JFileChooser();
         
        if (e.getSource() == imagePath) {
            fc.setDialogTitle("select an Image");
          FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif", "bmp", "tif", "tiff", "webp", "svg", "ico");
          fc.addChoosableFileFilter(imageFilter);
          int result = fc.showOpenDialog(null);
          if (result == JFileChooser.APPROVE_OPTION) {
          selectedFile = fc.getSelectedFile();
          if(selectedFile != null){
          selectedImage = selectedFile.getAbsolutePath();
          System.out.println(selectedImage);
        }
         // You can use the selected file path for further processing (e.g., displaying the image).
     } else {
         System.out.println("No file selected.");
     }
            
        }else{
              
            App.addFreind(name,selectedImage);
         freindform.setVisible(false);
         App.frame.setVisible(true);
        }
 
        
      }
      
     }

     MyListener m = new MyListener();
     add.addActionListener(m);
     imagePath.addActionListener(m);

        

       }
}

