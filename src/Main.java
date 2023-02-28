import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        try {

            //Step 1 : Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver install..");

            //Step 2  : get the connection using driver manager
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","root");
            if(conn.isClosed()){
                System.out.println("no connectio");
            }else{
                System.out.println("connected");
            }
            Scanner scanner =new Scanner(System.in);

//            System.out.println("enter the name : ");
//            String pname = scanner.next();
//            System.out.println("enter the pass: ");
//            int ppws = scanner.nextInt();
//            String query = "select * from emp where User = ? and Pass = ? ";
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1,pname);
//            ps.setInt(2,ppws);
//            System.out.println(ps);
//            ResultSet rs  = ps.executeQuery();
//            while(rs.next());
            
            //Step 3 : creating table via query
           // String q="create table mytest( tId int(20) primary key auto_increment, tName varchar(50) not null)";
          // Statement stmt=conn.createStatement();// Statement is used for dynamic quering like String q query;
          //  System.out.println("Table created !");
         //  stmt.executeUpdate(q);
         //  conn.close();
            
           //Step 3.1 : creating dynamic query

          //additonal data
          //System.out.println("enter the name : ");
          //String pname = scanner.next();
          //System.out.println("enter the pass: ");
          //int ppws = scanner.nextInt();
          
           String q="insert into mytest(tName)values(?)"; // String q=(insert into mytest values(?));
           PreparedStatement pstmt=conn.prepareStatement(q);
           
           //Buffer reader to get input from user
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           
           System.out.println("Enter Name : ");
           String name=br.readLine();
           pstmt.setString(1, name);
           
           pstmt.executeUpdate();
           System.out.println("data inserted");
            
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("driver(jar file ) not found !!!");

        } catch (SQLException e) {

            System.out.println("plz check the path .....");
        }
    }
}