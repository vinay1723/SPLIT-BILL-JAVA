import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class App {

    public static JFrame frame;
    String [] names = {"you"};
    
    public static JComboBox<String> Billpay; 
    public static JPanel freindList;
    public static ArrayList<FreindDetails> details = new ArrayList<>();
    public static ArrayList<FreindItem> frndItems = new ArrayList<>();
    public static JPanel footer;
    public static JButton addFriend;
    public static JButton groupsplit;
    public static JButton removeFriend;
    public static FreindItem Selecteditem;
    // public static SplitBill selectedBillform;
    public static JPanel rest;
    public static Boolean isfilled = false;
    public static JPanel box ;
    public static JFrame Group;
    App() throws Exception {
        frame = new JFrame("SplittBill");
        frame.setSize(1055,709);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.MAGENTA);
        frame.setResizable(true);


        
        rest = new JPanel();
        rest.setPreferredSize(new Dimension(620, 300));
        rest.setBackground(new Color(33,37,41));

       
        
        Billpay =  new JComboBox(names);
        Billpay.setFont(new Font("SANS_SERIF",0,19));
        Billpay.setPreferredSize(new Dimension(245, 45));
    
         freindList = new JPanel();
        //  freindList.setLayout(new GridLayout(0, 1));
        freindList.setMinimumSize(new Dimension(400, 700));
        freindList.setLayout(new BoxLayout(freindList,BoxLayout.Y_AXIS));
        // freindList.setSize(400,300);
        freindList.setBackground(Color.CYAN);

         box = new JPanel(new BorderLayout());
        // box.setPreferredSize(new Dimension(450, 40));
        JPanel space = new JPanel();
        space.setSize(new Dimension(150,40));
        space.setBackground(new Color(33,37,41));
         addFriend = new JButton("+ AddFriend");
         addFriend.setMaximumSize(new Dimension(300,40));
         addFriend.setFont(new Font("SANS_SERIF",1,20));
         addFriend.setBackground(Color.yellow);
         addFriend.setForeground(new Color(33,37,41));

         removeFriend = new JButton("- removeFriend");
         removeFriend.setMaximumSize(new Dimension(300,40));
         removeFriend.setFont(new Font("SANS_SERIF",1,20));
         removeFriend.setBackground(Color.yellow);
         removeFriend.setForeground(new Color(33,37,41));

         groupsplit = new JButton("GroupSplit");
      groupsplit.setMaximumSize(new Dimension(300,40));
      groupsplit.setFont(new Font("SANS_SERIF",1,20));
      groupsplit.setBackground(Color.yellow);
      groupsplit.setForeground(new Color(33,37,41));


         JLabel gapbutton = new JLabel("nnn");
         gapbutton.setFont(new Font("SANS_SERIF",0,20));
          gapbutton.setForeground(new Color(33,37,41)); 

         JLabel gapbutton1 = new JLabel("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
         gapbutton.setFont(new Font("SANS_SERIF",0,20));
          gapbutton.setForeground(new Color(33,37,41)); 
        //   gapbutton1.setVisible(false); 
          freindList.add(addFriend);
         footer = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
        footer.setMaximumSize(new Dimension(360, 100));
        // footer.setSize(400,300);
        footer.setBackground(new Color(33,37,41));
        footer.setForeground(new Color(33,37,41));
        

         new getData();
        for(FreindDetails friend : details){
            FreindItem fr1 = new FreindItem(friend.name,friend.debt.toString(),friend.image);
            JPanel fr = fr1.panel();
            if(friend.active == true){
                frndItems.add(fr1);
               freindList.add(fr1.verticalspace);
               freindList.add(fr);
            }
            
            frame.setVisible(true);
      }
      Group = new GroupSplit().panel();
    
        
        
        
       
        JScrollPane scrollPane = new JScrollPane(freindList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        footer.add(addFriend);
        footer.add(gapbutton);
        footer.add(removeFriend);
        footer.add(gapbutton1);
        footer.add(groupsplit);
        
        
        frame.add(BorderLayout.WEST,scrollPane);
        frame.add(BorderLayout.SOUTH,footer);
        frame.setVisible(true);
       
        class MyListener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                   if (e.getSource() == addFriend) {
                      
                    new FreindAddingForm();
    
                   }
                   if(e.getSource() == removeFriend){
                    if(Selecteditem == null) return;
                    freindList.remove(Selecteditem.panel());
                    freindList.remove(Selecteditem.verticalspace);
                    rest.setVisible(false);
                    freindList.revalidate();
                    freindList.repaint();
                    
                    for(FreindDetails fr1:details){
                        if(fr1.name.equals(Selecteditem.friendName.getText())){
                            details.remove(fr1);
                            try{
                               
                                getData.delete(Selecteditem.friendName.getText(), false);
                            }catch(Exception ec){
                                  System.out.println(ec.getMessage());
                            }
                            break;                        }
                    }
                    for(Freind1 fr:GroupSplit.friendlist1){
                        if(fr.friendName.getText().equals(Selecteditem.friendName.getText())){
                            GroupSplit.friendlist1.remove(fr);
                            GroupSplit.freinddetails1.remove(fr.panel());
                            GroupSplit.freinddetails1.remove(fr.verticalspace);
                            break;
                        }
                    }
                   
                    frame.setVisible(true);
                    // Group.setVisible(true);


                   }
                   if(e.getSource() == groupsplit){
                    Group.setVisible(true);
                   }
            }
        }
    
        MyListener m = new MyListener();
        addFriend.addActionListener(m);
        removeFriend.addActionListener(m);
        groupsplit.addActionListener(m);
        
    
    }

    public static void updateBalance(Double balance){
        for(FreindDetails detail: details){
            if(detail.name.equals(Selecteditem.friendName.getText())){
                detail.debt = detail.debt + balance;
                if(detail.debt > 0) {
                    detail.debtStatus = detail.name + " Owes you " + String.format("%.2f",detail.debt)+"/-";
                    Selecteditem.debtStatus.setText(detail.debtStatus);
                    Selecteditem.debtStatus.setForeground(Color.green);
                    freindList.setVisible(true);
                } else if(detail.debt < 0) {
                    detail.debtStatus = "You owe " + detail.name + " " + String.format("%.2f",Math.abs(detail.debt))+"/-";
                    Selecteditem.debtStatus.setText(detail.debtStatus);
                    Selecteditem.debtStatus.setForeground(Color.red);
                    freindList.setVisible(true);
                } else if(detail.debt == 0) {
                    detail.debtStatus = "You both are even 0"+"/-";
                    Selecteditem.debtStatus.setText(detail.debtStatus);
                    Selecteditem.debtStatus.setForeground(Color.white);
                    freindList.setVisible(true);
                }
                try{
                    getData.update(detail.name, detail.debt);
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
                
            }
        }
        frame.setVisible(true);
    }

    public static void addFreind(String name,String path){
        String path1 =  path == null?"splitBill\\src\\images\\blank-profile-picture-973460_1280.png":path;
        FreindDetails freind  = new FreindDetails(name,path1,0.00);
        details.add(freind);


        FreindItem fr1 = new FreindItem(name,freind.debt.toString(),path1);
        frndItems.add(fr1);
        JPanel fr = fr1.panel();
        freindList.add(fr1.verticalspace);
        freindList.add(fr);
           
          Freind1 frnd1 = new Freind1(name, path1);
          GroupSplit.friendlist1.add(frnd1);
          GroupSplit.freinddetails1.add(frnd1.panel());
          GroupSplit.freinddetails1.add(frnd1.verticalspace);
          String path2 = path1.replace("\\", "/");
          String path3 = path2.replace("/","//");
          
          try{
           
            getData.insert(name, 0.00, path3);
          }catch(Exception e){
            System.out.println(e.getMessage());
          }
         
        
        frame.setVisible(true);  
        FreindAddingForm.friendForm.setVisible(false);      
    }
     
    public static void main(String[] args) throws Exception {
           new App();
        
    }

    public static class FreindDetails {
        String name;
        String image;
        Double debt;
        String debtStatus;
        boolean active = true;
     
        FreindDetails(String name,String image,Double dept){
           this.name = name;
           this.image = image;
           this.debt = dept;
           this.debtStatus = "you  both are even 0/-";
        }
     }

     
    

    
}



