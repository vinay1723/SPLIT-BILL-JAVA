import java.sql.*;


public  class getData {

  public static  Statement stmt;
  public static  Connection con;

  getData(){
    try{
      con=
      DriverManager.getConnection("jdbc:mysql://localhost:3306/friendsdata", "root", "Vinay@1729");
      
      stmt = con.createStatement();
      
      // stmt.executeUpdate("insert into student values (\"Ravi Kant Sahu\", 535)");
      ResultSet rs = stmt.executeQuery("select * from friends WHERE active=true");
      while(rs.next()){
          String name = rs.getString("name");
          String path = rs.getString("imagepath");
          Double dept = rs.getDouble("dept");
         App.details.add(new App.FreindDetails(name, path,dept));
          
      }
      System.out.println();
      }
      catch(Exception ex) { System.out.println(ex); }
  }

  public static void update(String name,Double deptmoney) throws Exception{
    try{
      stmt.executeUpdate("UPDATE friends SET dept="+deptmoney+"WHERE name='"+name+"'");
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  public static void insert(String name,Double deptmoney,String path) throws Exception{
    try{
      stmt.executeUpdate("INSERT INTO friends (name,imagepath,dept,active) VALUES ('"+name+"','"+path+"',"+deptmoney+","+"true)");
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  public static void delete(String name,boolean status) throws Exception{
    try{
      stmt.executeUpdate("UPDATE friends SET active="+status+" WHERE name='"+name+"'");
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  
}
