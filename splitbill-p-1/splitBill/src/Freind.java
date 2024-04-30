import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


  
public class Freind {

     String selectedFreind;
     JPanel verticalspace;
     JFrame frame1;
     JPanel fr1;
     JPanel subPanel1;
     JPanel subPanel;
     CircularImagePanel c1; 
     JLabel friendName;
     JLabel debtStatus;
     JButton select;
     Boolean isSelected = false;
     Freind(String name,String status,String image){

      this.verticalspace = new JPanel();
      this.verticalspace.add(Box.createVerticalStrut(7));
      this.verticalspace.setMaximumSize(new Dimension(550,5));
      this.verticalspace.setBackground(Color.cyan);
       this.fr1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 8));
      this.fr1.setMaximumSize(new Dimension(450,95));
      this.fr1.setBackground(Color.BLACK);

      this.subPanel1 = new JPanel();
      this.subPanel1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
      this.subPanel1.setPreferredSize(new Dimension(300,95));
      this.subPanel1.setBackground(Color.BLACK);
      
      this.subPanel = new JPanel();
      this.subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
      this.subPanel.setPreferredSize(new Dimension(200,60));
      this.subPanel.setBackground(Color.BLACK);
     

       this.c1 = new CircularImagePanel(image);
      // fr1.add(c1);
      this.friendName = new JLabel(name);
      this.friendName.setFont(new Font("SANS_SERIF",0,20));
      this.friendName.setSize(30,20);
      this.friendName.setBackground(Color.red);
      this.friendName.setForeground(Color.WHITE);
      this.debtStatus= new JLabel(status);
      this.debtStatus.setFont(new Font("SANS_SERIF",1,12));
      this.debtStatus.setSize(35,20);
      this.debtStatus.setBackground(Color.red);
      this.debtStatus.setForeground(Color.WHITE);
     
      // fr1.add(l3);
      subPanel.add(friendName);
      subPanel.add(Box.createVerticalStrut(6));
      subPanel.add(debtStatus);
      subPanel1.add(c1);
      subPanel.add(Box.createHorizontalStrut(15));
      subPanel1.add(subPanel);
      
      this.select = new JButton("Select");
      this.select.setPreferredSize(new Dimension(85, 35));
      this.select.setBackground(Color.ORANGE);this.select.setFont(new Font("Arial", Font.BOLD, 16));

      fr1.add(subPanel1);
      
      fr1.add(select);

      class Mylistener  implements ActionListener {

    
          public void actionPerformed(ActionEvent e) {
               
              Freind freind = myself();
              selectedFreind = freind.friendName.getText();
              // App.Selecteditem = freind;
               
              if(freind.isSelected == false) {
                if(App.Selecteditem != null){
                  App.Selecteditem.fr1.setBackground(Color.BLACK);
                  App.Selecteditem.subPanel1.setBackground(new Color(0,0,0));
                App.Selecteditem.subPanel.setBackground(new Color(0,0,0));
                App.Selecteditem.c1.c = new Color(0,0,0);
                  App.Selecteditem.isSelected = false;
                  App.freindList.setVisible(true);
                }

                  // App.Selecteditem = freind;
                  App.Selecteditem.isSelected = true;
                  // App.frame.setVisible(true);

              
              } 
              if(App.Selecteditem.isSelected){
                App.Selecteditem.fr1.setBackground(new Color(33,37,41));
                App.Selecteditem.subPanel1.setBackground(new Color(33,37,41));
                App.Selecteditem.subPanel.setBackground(new Color(33,37,41));

                App.Selecteditem.c1.c = new Color(33,37,41);
                  App.frame.setVisible(true);
              }
             
                
                  if(App.isfilled == false){
                  JPanel splitbill = new SplitBill(selectedFreind).panel();
                  App.rest = splitbill;
                  App.frame.add(splitbill,BorderLayout.EAST);
                  App.isfilled = true;
                  App.frame.setVisible(true);
                  }else {
                      App.rest.setVisible(false);
                  JPanel splitbill = new SplitBill(selectedFreind).panel();
                  App.rest = splitbill;
                  App.frame.add(splitbill,BorderLayout.EAST);
                  App.frame.setVisible(true);
                  }
            
          }

          }

          Mylistener m = new Mylistener();
          this.select.addActionListener(m);
     
      
     }

     Freind myself()
      {
         
          return this;
      }


      
        
          
              
          
         

     public JPanel panel(){
       
      return this.fr1;
     }
   

    
     
  

  


     
}



