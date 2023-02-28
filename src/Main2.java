import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class Main2 {

	public static void main(String[] args) {
		//JDBC
		
		try {
			//step 1: Driver with class
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Created");
			
			//step 2: Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest1","root","root");
			if(con.isClosed()) {
				System.out.println("Connection is closed");
			}else {
				System.out.println("Connected");
			}
			
			//step 3 : statement with queries
			
			//String q="create table mytest(tId int(20) primary key auto_increment,tName varchar(20) not null, tAddress varchar(50) not null)";
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate(q);
			//System.out.println("Table created ");
			//con.close();
			
			//step 3.1 : query for inserting values;
			String q="insert into mytest values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1, "John");
			pstmt.setString(2, "USA");
			//pstmt.setInt(1, 10000); setInt if integer like price or amount
			System.out.println("Data inserted");
			con.close();
		}catch(Exception e) {
			e.printStackTrace(); 
		}

	}

}
