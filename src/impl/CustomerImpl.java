package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import interfaces.Customers;
import model.CustomerDAO;

public class CustomerImpl implements Customers {
	private Scanner sc=new Scanner(System.in);
	CustomerDAO cd=new CustomerDAO();

	@Override
	public void signinCustomer() throws SQLException {
		System.out.println("Customer Sign-In");
        System.out.println("--------------------");
        System.out.println("Enter Customer ID:");
		String t;
		t=sc.nextLine();
		cd.setCustomer_ID(t);
		System.out.println("Enter Customer Name:");
		t=sc.nextLine();
		cd.setCustomer_Name(t);
		System.out.println("Enter password:");
		t=sc.nextLine();
		cd.setPassword(t);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("INSERT INTO Customers(customer_id,customer_name,password) VALUES('"+ 
					//cd.getCustomer_ID()+"','"+cd.getCustomer_Name()+"','"+cd.getPassword()+"')");
	        stmt.executeUpdate("INSERT INTO Customers(customer_id,customer_name,password) VALUES('"+ 
			cd.getCustomer_ID()+"','"+cd.getCustomer_Name()+"','"+cd.getPassword()+"')");
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("Customer Account is created");
			System.out.println("Restart application to log-in");
		}
		
	
		
	}

	@Override
	public boolean loginCustomer() throws SQLException {
		boolean flag=false;
		System.out.println("Customer Log-In");
        System.out.println("--------------------");
        System.out.println("Enter Customer ID:");
		String id,password;
		id=sc.nextLine();
		cd.setCustomer_ID(id);
		System.out.println("Enter password:");
		password=sc.nextLine();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("SELECT * FROM CustomerS WHERE Customer_id='"+id+"' AND password='"+password+"'");
	        ResultSet rs=stmt.executeQuery("SELECT * FROM Customers WHERE customer_id='"+id+"' AND password='"+password+"'");
	        while(rs.next())
	        {
	        	flag=true;
	        }
	        if(flag)
	        {
	        	System.out.println("Login Successful\n");
	        	
	        }
	        else{
	        	System.out.println("Incorrect ID or Password\n");
	        	
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
	public void viewProducts() throws SQLException {
		System.out.println("Products View");
		System.out.println("--------------------");
		System.out.println("|id | product_id |  product_name  | product_description | price |");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("SELECT * FROM PRODUCTS");
	        ResultSet rs=stmt.executeQuery("SELECT id,product_id,product_name,product_description,price FROM PRODUCTS WHERE status=true");
	        while(rs.next())
	        {
	        	System.out.println("|"+rs.getInt(1)+"|"+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getFloat(5)+" |");
	        }
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("All products are listed\n");
		}
		
	}
		
	

	@Override
	public void viewdetailProduct() throws SQLException {
		System.out.println("Detailed Product View");
		System.out.println("--------------------");
		System.out.println("Enter the Product ID:");
		String t;
		t=sc.nextLine();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("SELECT p.product_id,p.product_name,"
    		//+ "p.product_description,p.price, s.seller_name FROM products p "
    		//+ "INNER JOIN sellers s ON s.seller_id=p.seller_id HAVING product_id='"+t+"'");
	        ResultSet rs=stmt.executeQuery("SELECT p.product_id,p.product_name,"
	        		+ "p.product_description,p.price, s.seller_name FROM products p "
	        		+ "INNER JOIN sellers s ON s.seller_id=p.seller_id HAVING product_id='"+t+"'");
	       rs.next();
	       System.out.println("Product ID:"+rs.getString(1));
	       System.out.println("Product Name:"+rs.getString(2));
	       System.out.println("Product Description:"+rs.getString(3));
	       System.out.println("Product Price:"+rs.getFloat(4));
	       System.out.println("Seller Name:"+rs.getString(5));
	       
	       System.out.println("Reviews");
	       System.out.println("--------------------");
	       System.out.println("| customer_name | review |");
	       ResultSet rs1=stmt.executeQuery("SELECT c.customer_name,r.review_description FROM reviews r "
	       		+ "INNER JOIN customers c ON c.customer_id=r.customer_id WHERE r.product_id='"+t+"'");
	       while(rs1.next())
	       {
	    	   System.out.println("| "+rs1.getString(1)+" | "+rs1.getString(2)+" | ");
	       }
	       
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("-----------------\n");
		}
		
	}

	@Override
	public void addtoCart() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String product_id;
			System.out.println("Add Product to Cart");
			System.out.println("--------------------");
			System.out.println("Enter Product ID:");
			product_id=sc.nextLine();
			Statement stmt =con.createStatement();
			//System.out.println("INSERT INTO CARTS(product_id,customer_id,bought)VALUES ('"+
			  //product_id+"','"+cd.getCustomer_ID()+"',false)");
			  
			  stmt.executeUpdate("INSERT INTO CARTS(product_id,customer_id,bought)VALUES ('"+
			  product_id+"','"+cd.getCustomer_ID()+"',false)");
			}
			catch(Exception e1)
			{
				System.out.println("Error Occured:");
				e1.printStackTrace();
				
			}		
			finally {
				
				con.close();
				System.out.println("Product is added successfully\n");
			}
		
	}

	@Override
	public void viewCart() throws SQLException {
		System.out.println("Cart View");
		System.out.println("--------------------");
		System.out.println("| product_id |  product_name | price |");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("SELECT c.product_id,p.product_name,p.price FROM CARTS c INNER JOIN "
	        	//	+ "PRODUCTS p ON p.product_id=c.product_id WHERE c.customer_id='"+cd.getCustomer_ID()+"'");
	        ResultSet rs=stmt.executeQuery("SELECT c.product_id,p.product_name,p.price FROM CARTS c INNER JOIN "
	        		+ "PRODUCTS p ON p.product_id=c.product_id WHERE bought=false AND c.customer_id='"+cd.getCustomer_ID()+"'");
	        while(rs.next())
	        {
	        	System.out.println("|"+rs.getString(1)+"|"+"|"+rs.getString(2)+"| "+rs.getFloat(3)+" |");
	        }
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("---------\n");
		}
		
	}

	@Override
	public void addReview() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String product_id,customer_id,review;
			System.out.println("Enter Product Review");
			 System.out.println("--------------------");
			System.out.println("Enter Product ID:");
			product_id=sc.nextLine();
			customer_id=cd.getCustomer_ID();
			System.out.println("Type your Review:");
			review=sc.nextLine();
			Statement stmt =con.createStatement();
			  //System.out.println("INSERT INTO REVIEWS(product_id,customer_id,review_description) VALUES('"+
			  //product_id+"','"+customer_id+"','"+review+"')");
			  
			  stmt.executeUpdate("INSERT INTO REVIEWS(product_id,customer_id,review_description) VALUES('"+
					  product_id+"','"+customer_id+"','"+review+"')");
			}
			catch(Exception e1)
			{
				System.out.println("Error Occured:");
				e1.printStackTrace();
				
			}		
			finally {
				
				con.close();
				System.out.println("Product Review is entered successfully\n");
			}
			
		
	}

	@Override
	public void buyProducts() throws SQLException {
		ArrayList<String> al =new ArrayList<String>();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("SELECT product_id FROM CARTS WHERE customer_id='"+cd.getCustomer_ID()+"'");
        ResultSet rs=stmt.executeQuery("SELECT product_id FROM CARTS WHERE customer_id='"+cd.getCustomer_ID()+"'");
		while(rs.next())
		{
			al.add(rs.getString(1));
		}
		for(int i=0;i<al.size();i++)
		{
			stmt.executeUpdate("INSERT INTO SALES(product_id,customer_id) VALUES('"+
					  al.get(i)+"','"+cd.getCustomer_ID()+"')");
		}
		for(int i=0;i<al.size();i++)
		{
			//System.out.println("UPDATE CARTS SET bought=true WHERE product_id='"+
					  //al.get(i)+"' AND customer_id='"+cd.getCustomer_ID()+"'");
			stmt.executeUpdate("UPDATE CARTS SET bought=true WHERE product_id='"+al.get(i)+"' AND customer_id='"+cd.getCustomer_ID()+"'");
			//System.out.println("UPDATE PRODUCTS SET quantity=quantity-1 WHERE product_id='"+
					  //al.get(i)+"'");
			stmt.executeUpdate("UPDATE PRODUCTS SET quantity=quantity-1 WHERE product_id='"+
					  al.get(i)+"'");
		}
		
		}
		catch(Exception e1)
		{
			System.out.println("Error Occured:");
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("Items are bought sucessfully\n");
		}
	}

	@Override
	public void viewProductsBought() throws SQLException {
		System.out.println("Order View");
		System.out.println("--------------------");
		System.out.println("| product_id |  product_name | price |");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("SELECT c.product_id,p.product_name,p.price FROM CARTS c INNER JOIN "
	        	//	+ "PRODUCTS p ON p.product_id=c.product_id WHERE c.customer_id='"+cd.getCustomer_ID()+"'");
	        ResultSet rs=stmt.executeQuery("SELECT s.product_id,p.product_name,p.price FROM sales s INNER JOIN "
	        		+ "PRODUCTS p ON p.product_id=s.product_id WHERE s.customer_id='"+cd.getCustomer_ID()+"'");
	        while(rs.next())
	        {
	        	System.out.println("|"+rs.getString(1)+"|"+"|"+rs.getString(2)+"| "+rs.getFloat(3)+" |");
	        }
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("---------\n");
		}
	
		
	}

}
