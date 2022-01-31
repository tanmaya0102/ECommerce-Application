package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import interfaces.Sellers;
import model.ProductsDAO;
import model.SellerDAO;
public class SellerImpl implements Sellers {
	
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
		sd.setSeller_ID(id);
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
	public void addProducts() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			ProductsDAO pd =new ProductsDAO();
			String t; float price;int quantity;boolean status;
			System.out.println("Enter Product Details");
			 System.out.println("--------------------");
			System.out.println("Enter Product ID:");
			t=sc.nextLine();
			pd.setProduct_ID(t);
			System.out.println("Enter Seller ID:");
			//sc.nextLine();
			t=sc.nextLine();
			pd.setSeller_ID(t);
			System.out.println("Enter Product Name:");
			t=sc.nextLine();
			pd.setProduct_Name(t);
			System.out.println("Enter Product Description:");
			t=sc.nextLine();
			pd.setProduct_Description(t);
			System.out.println("Enter Price:");
			price=sc.nextFloat();
			pd.setPrice(price);
			System.out.println("Enter Quantity:");
			quantity=sc.nextInt();
			pd.setQuantity(quantity);
			System.out.println("Enter Status:");
			status=sc.nextBoolean();
			pd.setStatus(status);
			
		  Statement stmt =con.createStatement();
		  //System.out.println("INSERT INTO PRODUCTS(product_id,seller_id,product_name,product_description,price,quantity,status  ) VALUES('"+
				  //pd.getProduct_ID()+"','"+pd.getSeller_ID()+"','"+pd.getProduct_Name()+"','"+pd.getProduct_Description()+"',"
				  //+pd.getPrice()+","+pd.getQuantity()+","+pd.isStatus()+")");
		  
		  stmt.executeUpdate("INSERT INTO PRODUCTS(product_id,seller_id,product_name,product_description,price,quantity,status  ) VALUES('"+
				  pd.getProduct_ID()+"','"+pd.getSeller_ID()+"','"+pd.getProduct_Name()+"','"+pd.getProduct_Description()+"',"
				  +pd.getPrice()+","+pd.getQuantity()+","+pd.isStatus()+")");
		}
		catch(Exception e1)
		{
			System.out.println("Error Occured:");
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("Product is entered successfully\n");
		}
		
		
	}

	@Override
	public void deleteProducts() throws SQLException { 
		String t;
		System.out.println("Delete Products");
		System.out.println("--------------------");
		System.out.println("Enter Product ID:");
		t=sc.nextLine();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("UPDATE PRODUCTS SET STATUS=false WHERE PRODUCT_ID='"+t+"'");
	        stmt.executeUpdate("UPDATE PRODUCTS SET STATUS=false WHERE PRODUCT_ID='"+t+"'");
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("Product is deleted\n");
		}
		
		
	}

	@Override
	public void updateProducts() throws SQLException {
		System.out.println("Update Products");
        System.out.println("--------------------");
        float price;int quantity;boolean status;String id;
        System.out.println("Enter the Product ID:");
        id=sc.nextLine();
        System.out.println("Enter the Updated Price:");
        price=sc.nextFloat();
        System.out.println("Enter the Updated Quanity:");
        quantity=sc.nextInt();
        System.out.println("Enter the Updated Status");
        status=sc.nextBoolean();
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println();
	        stmt.executeUpdate("UPDATE PRODUCTS SET STATUS="+status+",PRICE="+
			price+", QUANTITY="+quantity+" WHERE PRODUCT_ID='"+id+"'");
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("Product is updated\n");
		}
		
		
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
			System.out.println("Restart application to log-in");
		}
		
	}

	@Override
	public void viewProducts() throws SQLException {
		System.out.println("Products View");
		System.out.println("--------------------");
		System.out.println("|id| product_id | seller_id |  product_name  | product_description | price | quantity | status  |");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","ankit");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt=con.createStatement();
			//System.out.println("SELECT * FROM PRODUCTS");
	        ResultSet rs=stmt.executeQuery("SELECT * FROM PRODUCTS WHERE seller_id='"+sd.getSeller_ID()+"'");
	        while(rs.next())
	        {
	        	System.out.println("|"+rs.getInt(1)+"|"+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+
	        			"|"+rs.getString(5)+"|"+rs.getFloat(6)+"|"+rs.getInt(7)+"|"+rs.getBoolean(8)+"|");
	        }
	        
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("All products are listed");
		}
		
	}

}
