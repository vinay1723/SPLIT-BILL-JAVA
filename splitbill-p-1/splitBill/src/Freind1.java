import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


  
public class Freind1 {

     String selectedFreind;
     JPanel verticalspace;;
     JFrame frame1;
     JPanel fr1;
     JPanel subPanel1;
     JPanel subPanel;
     CircularImagePanel c1; 
     JLabel friendName;
     JLabel debtStatus;
     JButton select;
     Boolean isSelected = false;
     JTextField bill; 
    //  JPanel freinddetails = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
   
     Freind1(String name,String image){

      // this.freinddetails.setPreferredSize(new Dimension(600, 300));
      // this.freinddetails.setBackground(new Color(33,37,41));
      this.bill = new JTextField();
      this.bill.setFont(new Font("SANS_SERIF",0,19));
      this.bill.setPreferredSize(new Dimension(170, 45));
      
      this.verticalspace = new JPanel();
      this.verticalspace.add(Box.createVerticalStrut(7));
      this.verticalspace.setMaximumSize(new Dimension(450,2));
      this.verticalspace.setBackground(new Color(33,37,41));
       this.fr1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
      this.fr1.setMaximumSize(new Dimension(480,105));
      this.fr1.setBackground(Color.BLACK);
         

       


      this.subPanel1 = new JPanel();
      this.subPanel1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
      this.subPanel1.setPreferredSize(new Dimension(250,95));
      this.subPanel1.setBackground(Color.black);
      
      this.subPanel = new JPanel();
      this.subPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
      this.subPanel.setPreferredSize(new Dimension(200,60));
      this.subPanel.setBackground(Color.cyan);
     

       this.c1 = new CircularImagePanel(image);
      fr1.add(c1);
      this.friendName = new JLabel(name);
      this.friendName.setFont(new Font("SANS_SERIF",0,20));
      this.friendName.setSize(30,20);
      this.friendName.setBackground(Color.red);
      this.friendName.setForeground(Color.WHITE);
      // this.debtStatus= new JLabel(status);
      // this.debtStatus.setFont(new Font("SANS_SERIF",1,12));
      // this.debtStatus.setSize(35,20);
      // this.debtStatus.setBackground(Color.red);
      // this.debtStatus.setForeground(Color.WHITE);
     
      // fr1.add(l3);
      subPanel.add(friendName);
      subPanel.add(Box.createVerticalStrut(6));
      // subPanel.add(debtStatus);
      subPanel1.add(c1);
      subPanel.add(Box.createHorizontalStrut(15));
      subPanel1.add(friendName);
      
      this.select = new JButton("Select");
      this.select.setPreferredSize(new Dimension(85, 35));
      this.select.setBackground(Color.ORANGE);this.select.setFont(new Font("Arial", Font.BOLD, 16));

      fr1.add(subPanel1);
      
      fr1.add(bill);
      fr1.add(Box.createHorizontalStrut(15));

      class Mylistener  implements ActionListener {

    
          public void actionPerformed(ActionEvent e) {
               
              Freind1 freind = myself();
              selectedFreind = freind.friendName.getText();
              
              
            
          }

          }

          Mylistener m = new Mylistener();
          this.select.addActionListener(m);
     
      
     }

     Freind1 myself()
      {
         
          return this;
      }


      public JTextField getTextField() {
        return this.bill;
    }
        
          
              
          
         

     public JPanel panel(){
       
      return this.fr1;
     }
   

    
     
  

  


     
}



