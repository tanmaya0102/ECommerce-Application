package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import interfaces.Sellers;
import model.SellerDAO;
public class SellersImpl implements Sellers {
	
	private Scanner sc=new Scanner(System.in);
	SellerDAO sd=new SellerDAO();

	@Override
	public boolean loginSeller() throws SQLException {
		boolean flag=false;
		System.out.println("Seller Log-In");
        System.out.println("--------------------");
        System.out.println("Enter Seller ID:");
		String id,password;
		id=sc.nextLine();
		System.out.println("Enter password:");
		password=sc.nextLine();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("SELECT * FROM SELLERS WHERE seller_id='"+id+"' AND password='"+password+"'");
	        ResultSet rs=stmt.executeQuery("SELECT * FROM SELLERS WHERE seller_id='"+id+"' AND password='"+password+"'");
	        while(rs.next())
	        {
	        	flag=true;
	        }
	        if(flag)
	        {
	        	System.out.println("Login Successful");
	        	
	        }
	        else{
	        	System.out.println("Incorrect ID or Password");
	        	
	        }
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			//System.out.println("Error Occurred");
			
		}
		return flag;
		
	}

	@Override
	public void addProducts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProducts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProducts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signinSeller() throws SQLException {
		System.out.println("Seller Sign-In");
        System.out.println("--------------------");
        System.out.println("Enter Seller ID:");
		String t;
		t=sc.nextLine();
		sd.setSeller_ID(t);
		System.out.println("Enter Seller Name:");
		t=sc.nextLine();
		sd.setSeller_Name(t);
		System.out.println("Enter password:");
		t=sc.nextLine();
		sd.setPassword(t);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("INSERT INTO SELLERS(seller_id,seller_name,password) VALUES('"+ 
					//sd.getSeller_ID()+"','"+sd.getSeller_Name()+"','"+sd.getPassword()+"')");
	        stmt.executeUpdate("INSERT INTO SELLERS(seller_id,seller_name,password) VALUES('"+ 
			sd.getSeller_ID()+"','"+sd.getSeller_Name()+"','"+sd.getPassword()+"')");
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("Seller Account is created");
		}
		
	}

}
