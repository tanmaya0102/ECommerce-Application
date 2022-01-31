package main;

import java.sql.SQLException;
import java.util.Scanner;

import impl.CustomerImpl;
import interfaces.Customers;

public class CustomerApp {
	public static void defmethod()
	{
		System.out.println("1.Customer SignIn");
		System.out.println("2.Customer LogIn");
		System.out.println("3.Exit");
		
	}
	public static void opmethod() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		int t;
		System.out.println("1.View Products");
		System.out.println("2.View Product in Detail");
		System.out.println("3.Add Product to Cart");
		System.out.println("4.View Cart");
		System.out.println("5.Add Review");
		System.out.println("6.Buy Products in Cart");
		System.out.println("7.Check Order Details");
		System.out.println("8.Exit");
		t=sc.nextInt();
		if(t==1)
		{
			customer.viewProducts();
			opmethod();
		}
		else if(t==2)
		{
			customer.viewdetailProduct();
			opmethod();
		}
		else if(t==3)
		{
			customer.addtoCart();
			opmethod();
		}
		else if(t==4)
		{
			customer.viewCart();
			opmethod();
		}
		else if(t==5)
		{
			customer.addReview();
			opmethod();
		}
		else if(t==6)
		{
			customer.buyProducts();
			opmethod();
		}
		else if(t==7)
		{
			customer.viewProductsBought();
			opmethod();
		}
		else if(t==7)
		{
			sc.close();
		   return;
		}
		sc.close();
	}
	private static Scanner sc;
	static Customers customer=new CustomerImpl();
	public static void main(String[] args) throws SQLException {
		sc=new Scanner(System.in);
		
		System.out.println("ShopMe Console Application - Customer Portal");
		System.out.println("---------------------------");
		int t=0;
		defmethod();
		t=sc.nextInt();
		if(t==1)
		{
			customer.signinCustomer();
		}
		
		else if(t==2)
		{
			boolean st;
			st=customer.loginCustomer();
			
			if(st==true)
			{
				opmethod();
			}
		}
		
		else if(t==3)
		{
			return;
		}
	}

}
