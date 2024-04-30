import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class GroupSplit {
  // static JPanel freinddetails = new JPanel(new FlowLayout(FlowLayout.CENTER,10,30));
 public  static JFrame freinddetails = new JFrame();
 public static ArrayList<Freind1> friendlist1 = new ArrayList<>();
  // static JPanel freinddetails1 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
  public static JPanel freinddetails1;
     GroupSplit(){
    //  freinddetails.setLayout(new BoxLayout(freinddetails, BoxLayout.Y_AXIS));
      // freinddetails.setPreferredSize(new Dimension(600, 400));
      freinddetails.setBackground(new Color(33,37,41));
      freinddetails.setSize(new Dimension(600, 790));
      freinddetails.setLocationRelativeTo(null);
      freinddetails.setBackground(new Color(33,37,41));
      freinddetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      freinddetails.setResizable(false);

      Container contentPane = freinddetails.getContentPane();
      contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
      // freinddetails1.setPreferredSize(new Dimension(620, 380));
      // freinddetails1.setBackground(new Color(33,37,41));
      freinddetails1 =  new JPanel();
      // freinddetails1.setMinimumSize(new Dimension(400, 250));
      // freinddetails1.setPreferredSize(new Dimension(400, 450)); 
      freinddetails1.setMaximumSize(new Dimension(480, 250));
        freinddetails1.setLayout(new BoxLayout(freinddetails1,BoxLayout.Y_AXIS));
        // System.out.println(freinddetails1.getSize().getWidth()+"height:-"+freinddetails1.getSize().getHeight());
        // freinddetails1.setPreferredSize(new Dimension(480, ));
        // freinddetails1.setLayout(new FlowLayout(FlowLayout.CENTER,10,30));

        // freinddetails1.setSize(400,300);
        freinddetails1.setBackground(new Color(33,37,41));
      JLabel friendName = new JLabel("SPLIT BILL WITH GROUP OF FREINDS");
    friendName.setFont(new Font("SANS_SERIF",1,28));
    friendName.setSize(450,20);
    friendName.setForeground(Color.cyan);
    friendName.setBackground(new Color(33,37,41));


    JPanel BillPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));
    BillPanel.setPreferredSize(new Dimension(450,50));
    BillPanel.setBackground(new Color(33,37,41)); 

    JPanel ButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));
    ButtonsPanel.setPreferredSize(new Dimension(450,50));
    ButtonsPanel.setBackground(new Color(33,37,41)); 
    

    JLabel Bill = new JLabel("BILL VALUE:   ");
    Bill.setFont(new Font("SANS_SERIF",1,23));
    Bill.setForeground(Color.YELLOW); 
    
    JTextField bill  = new JTextField("");
    bill.setFont(new Font("SANS_SERIF",0,19));
    bill.setPreferredSize(new Dimension(245, 45));

    JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,40,7));
    ButtonPanel.setPreferredSize(new Dimension(480,50));
    ButtonPanel.setBackground(new Color(33,37,41));

    JLabel button = new JLabel("nnnnnnnnnnnnn");
    button.setFont(new Font("SANS_SERIF",0,20));
    button.setForeground(new Color(33,37,41)); 

    JButton equalsplit = new JButton("Equal Split");
    equalsplit.setPreferredSize(new Dimension(150,40));
    equalsplit.setFont(new Font("SANS_SERIF",1,20));
    equalsplit.setBackground(Color.yellow);
    equalsplit.setForeground(new Color(33,37,41));

    JButton groupsplit = new JButton("Split");
    groupsplit.setPreferredSize(new Dimension(120,40));
    groupsplit.setFont(new Font("SANS_SERIF",1,20));
    groupsplit.setBackground(Color.yellow);
    groupsplit.setForeground(new Color(33,37,41));

   ButtonPanel.add(equalsplit);
   ButtonPanel.add(button);
   ButtonPanel.add(groupsplit);




   BillPanel.add(Bill);
   BillPanel.add(bill);



      contentPane.add(Box.createVerticalGlue());
      friendName.setAlignmentX(Component.CENTER_ALIGNMENT);
      BillPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
      ButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
      contentPane.add(Box.createVerticalStrut(30)); 
      contentPane.add(friendName);
      contentPane.add(Box.createVerticalStrut(20));
      contentPane.add(Box.createHorizontalStrut(40));
      contentPane.add(BillPanel);
      contentPane.add(Box.createVerticalStrut(20));


      System.out.println("reached");
     

      for(App.FreindDetails freind: App.details){
        // System.out.println(freind.name+"" +freind.image);
        if(freind.active == true){
          Freind1 fr0 = new Freind1(freind.name, freind.image);
        friendlist1.add(fr0);
        freinddetails1.add(fr0.panel());
        freinddetails1.add(fr0.verticalspace);
        }
        

      }
      System.out.println("passed");

      
      JScrollPane scrollPane = new JScrollPane(freinddetails1);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
      // scrollPane.setBounds(0, 0, 400, 400);
      contentPane.add(scrollPane);
      contentPane.add(ButtonPanel);
      // contentPane.add(BillPanel);
      contentPane.add(Box.createVerticalGlue());
      contentPane.setBackground(new Color(33,37,41));






      class Mylistener implements ActionListener {
    
        public void actionPerformed(ActionEvent e) {
           
          if(e.getSource() == equalsplit){

           Double TotalBill;Double numoffriends;Double splittedAmount;

            if( GroupSplit.isNumeric(bill.getText())){
              TotalBill =Double.parseDouble(bill.getText());
              if(TotalBill < 0){bill.setText("⚠️ Enter valid Amount"); return;}
            }else {
              bill.setText("⚠️ Enter Amount");return;
            }

             numoffriends =Double.parseDouble(String.valueOf(App.details.size()));
             splittedAmount = TotalBill/numoffriends;
             splittedAmount = Math.round(splittedAmount * 100) / 100.0;
             for(Freind1 friend:friendlist1)
             {   
              String result = String.format("%.2f", splittedAmount);
                friend.bill.setText(result);
               

             }
             freinddetails.setVisible(true);
             
          }else if(e.getSource() == groupsplit){
            Double TotalBill;Double sumoffriendsbill=0.0;
            if( GroupSplit.isNumeric(bill.getText())){
              TotalBill =Double.parseDouble(bill.getText());
              
              if(TotalBill < 0.0){bill.setText("⚠️ Enter valid Amount"); return;}
            }else {
              bill.setText("⚠️ Enter Amount");return;
            }
            Double check=0.00;
            for(Freind1 friend:friendlist1){
              if( GroupSplit.isNumeric(friend.bill.getText())){
                check = Double.parseDouble(friend.bill.getText());
                if(check < 0.0){friend.bill.setText("⚠️ Enter valid Amount"); return;}
              }else{
                System.out.println("wrong");
                friend.bill.setText("⚠️ Enter valid Amount"); return;
              }
               sumoffriendsbill =  sumoffriendsbill+check;
            }
              sumoffriendsbill = Double.parseDouble(String.valueOf(Math.round(sumoffriendsbill)));
              System.out.println(sumoffriendsbill);
            if(sumoffriendsbill.equals(TotalBill)){
              int i = 0;
              for(Freind1 friend:friendlist1){
                if( GroupSplit.isNumeric(friend.bill.getText())){
                  check = Double.parseDouble(friend.bill.getText());
    
                  if(check < 0.0){friend.bill.setText("⚠️ Enter valid Amount"); return;}
                }
                App.FreindDetails detail = App.details.get(i);
                FreindItem item = App.frndItems.get(i);
                detail.debt = detail.debt + check;
                if(detail.debt > 0.0) {
                    detail.debtStatus = detail.name + " Owes you " + String.format("%.2f",detail.debt)+"/-";
                    item.debtStatus.setText(detail.debtStatus);
                    item.debtStatus.setForeground(Color.green);
                    App.freindList.setVisible(true);
                } else if(detail.debt < 0.0) {
                    detail.debtStatus = "You owe " + detail.name + " " + String.format("%.2f",Math.abs(detail.debt))+"/-";
                    item.debtStatus.setText(detail.debtStatus);
                    item.debtStatus.setForeground(Color.red);
                    App.freindList.setVisible(true);
                } else if(detail.debt == 0.0) {
                    detail.debtStatus = "You both are even 0"+"/-";
                    item.debtStatus.setText(detail.debtStatus);
                    item.debtStatus.setForeground(Color.white);
                    App.freindList.setVisible(true);
                }
                 i++;
                 try{
                  getData.update(detail.name, detail.debt);
              }catch(Exception ec){
                  System.out.print(ec.getMessage());
              }
              }
            }
             
           

           freinddetails.setVisible(false);
             bill.setText("");
           for(Freind1 frnd1:friendlist1){
             frnd1.bill.setText("");
           }

          }
          
        }
      }
  
    
    Mylistener m = new Mylistener();
    equalsplit.addActionListener(m);
    App.Billpay.addActionListener(m);
    groupsplit.addActionListener(m);
   
     App.frame.setVisible(true);
















    }



     public JFrame panel(){
      return freinddetails;
     }

     public static ArrayList<Freind1> getFriends(){
      return friendlist1;
     }

     public static  boolean isNumeric(String str) {
      try {
          Double.parseDouble(str);
          return true;
      } catch (NumberFormatException e) {
        System.out.println(e.getMessage());
          return false;
      }

     
  }
}


