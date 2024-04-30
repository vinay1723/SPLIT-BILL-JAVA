import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SplitBill  {
    JPanel Billform = new JPanel(new FlowLayout(FlowLayout.CENTER,50,40));
  // JRadioButton jr1 = new JRadioButton("you");
  // JRadioButton jr2 = new JRadioButton();
  static String paidBy;
  // static JPanel optionPanel;
  // ButtonGroup bg1;
  public static Boolean isSelected = false;
  SplitBill(String name){
    Billform.setPreferredSize(new Dimension(620, 300));
    Billform.setBackground(new Color(33,37,41));


    JLabel friendName = new JLabel("SPLIT BILL WITH "+name.toUpperCase());
    friendName.setFont(new Font("SANS_SERIF",1,30));
    friendName.setSize(30,20);
    friendName.setForeground(Color.WHITE);



    JPanel BillPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
    BillPanel.setPreferredSize(new Dimension(425,50));
    BillPanel.setBackground(new Color(33,37,41));

    JLabel Bill = new JLabel("Bill value       ");
    Bill.setFont(new Font("SANS_SERIF",0,20));
    Bill.setForeground(Color.cyan); 
    
    JTextField bill  = new JTextField("");
    bill.setFont(new Font("SANS_SERIF",0,19));
    bill.setPreferredSize(new Dimension(245, 45));

   BillPanel.add(Bill);
   BillPanel.add(bill);




    JPanel myPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
    myPanel.setPreferredSize(new Dimension(425,50));
    myPanel.setBackground(new Color(33,37,41));


    JLabel myExpense = new JLabel("your Expense");
    myExpense.setFont(new Font("SANS_SERIF",0,20));
    myExpense.setForeground(Color.cyan); 
    
    JTextField mybill  = new JTextField("");
    mybill.setFont(new Font("SANS_SERIF",0,19));
    mybill.setPreferredSize(new Dimension(245, 45));

    myPanel.add(myExpense);
    myPanel.add(mybill);




    JPanel BillPayerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
    BillPayerPanel.setPreferredSize(new Dimension(425,50));
    BillPayerPanel.setBackground(new Color(33,37,41));

    JLabel BillPayer = new JLabel("who's paying ");
    BillPayer.setFont(new Font("SANS_SERIF",0,20));
    BillPayer.setForeground(Color.cyan); 

    


   
    BillPayerPanel.add(BillPayer);
    BillPayerPanel.add(App.Billpay);
    updateCombo(name);


    JPanel freindPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
    freindPanel.setPreferredSize(new Dimension(425,50));
    freindPanel.setBackground(new Color(33,37,41));

    JLabel freindExpense = new JLabel(name + "s Expense           ");
    freindExpense.setFont(new Font("SANS_SERIF",0,20));
    freindExpense.setForeground(Color.cyan); 

    JLabel freindBill = new JLabel("0/-");
    freindBill.setFont(new Font("SANS_SERIF",1,21));
    freindBill.setForeground(Color.yellow); 

    

    freindPanel.add(freindExpense);
    freindPanel.add(freindBill);
  


    JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
    ButtonPanel.setPreferredSize(new Dimension(425,50));
    ButtonPanel.setBackground(new Color(33,37,41));

    JLabel button = new JLabel("nnnnnnnnnnnnnn                    ");
    button.setFont(new Font("SANS_SERIF",0,20));
    button.setForeground(new Color(33,37,41)); 

    JButton split = new JButton("Split");
    split.setPreferredSize(new Dimension(100,40));
    split.setFont(new Font("SANS_SERIF",1,20));
    split.setBackground(Color.yellow);
    split.setForeground(new Color(33,37,41));

   ButtonPanel.add(button);
   ButtonPanel.add(split);

       



    Billform.add(friendName);
    Billform.add(BillPanel);
    Billform.add(myPanel);
    Billform.add(freindPanel);
    Billform.add(BillPayerPanel);
    Billform.add(ButtonPanel);




    class Mylistener implements ActionListener {
    
      public void actionPerformed(ActionEvent e) {
         
        if(e.getSource() == App.Billpay){
            paidBy = (String) App.Billpay.getSelectedItem();
        }
        
        if(e.getSource() == split) {
          Double TotalBill=0.00;Double myExpense=0.00;
          Double balance;
          if( SplitBill.isNumeric(bill.getText())){
            Double test = Double.parseDouble(bill.getText());
            TotalBill =  test instanceof Double ? test:Double.valueOf(bill.getText());
            if(TotalBill < 0){bill.setText("⚠️ Enter valid Amount"); return;}
          }else {
            bill.setText("⚠️ Enter valid Amount");return;
          }
           if(SplitBill.isNumeric(mybill.getText())){

             myExpense = Double.parseDouble(mybill.getText());
            if(myExpense < 0 || myExpense > TotalBill){mybill.setText("⚠️ Enter valid Amount");return;}
          }else {
            mybill.setText("⚠️ Enter valid Amount");return;
          }
          Double friendbill = TotalBill - myExpense;
          if(paidBy!=null){
             balance = paidBy == "you" ? friendbill:-myExpense;

             App.updateBalance(balance);
             bill.setText("");
             mybill.setText("");
             freindBill.setText("0/-");
            //  Billform.setVisible(false);
          }
            
          
         
        }
  
        if(e.getSource() == mybill){
          Double TotalBill;
          Double myExpense;
          if( SplitBill.isNumeric(bill.getText())){
            TotalBill = Double.parseDouble(bill.getText());
            if(TotalBill < 0){bill.setText("⚠️ Enter valid Amount"); return;}
          }else {
            bill.setText("⚠️ Enter valid Amount");return;
          }
           if(SplitBill.isNumeric(mybill.getText())){

             myExpense = Double.parseDouble(mybill.getText());
            if(myExpense < 0 || myExpense > TotalBill){mybill.setText("⚠️ Enter valid Amount");return;}
          }else {
            mybill.setText("⚠️ Enter valid Amount");return;
          }
          Double friendExpense = TotalBill - myExpense;
          freindBill.setText(String.format("%.2f",friendExpense)+"/-");
          // Billform.setVisible(true);
        }


        
      }
    }

    

  
  Mylistener m = new Mylistener();
  mybill.addActionListener(m);
  App.Billpay.addActionListener(m);
  split.addActionListener(m);
 
   App.frame.setVisible(true);
  }

  public static  boolean isNumeric(String str) {
    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

   JPanel panel(){
    // App.frame.getContentPane().add(Billform,BorderLayout.EAST);
    return Billform;

  }
  public static void updateCombo(String name) {
    App.Billpay.setSelectedItem("you");
    if(App.Billpay.getItemCount() > 1){
      // System.out.println(App.Billpay.getItemCount());
      App.Billpay.removeItemAt(1);
      App.Billpay.addItem(name);
    }else{
      App.Billpay.addItem(name);
    }
  }
  
}



 
    
   

  

