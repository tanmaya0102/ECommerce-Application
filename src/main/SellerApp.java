package main;

import java.sql.SQLException;
import java.util.Scanner;

import impl.SellerImpl;
import interfaces.Sellers;

public class SellerApp {
	public static void defmethod()
	{
		System.out.println("1.Seller SignIn");
		System.out.println("2.Seller LogIn");
		System.out.println("3.Exit");
		
	}
	public static void opmethod() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		int t;
		System.out.println("1.Add Product");
		System.out.println("2.View Products");
		System.out.println("3.Update Product");
		System.out.println("4.Delete Product");
		System.out.println("5.Exit");
		t=sc.nextInt();
		if(t==1)
		{
			seller.addProducts();
			opmethod();
		}
		else if(t==2)
		{
			seller.viewProducts();
			opmethod();
		}
		else if(t==3)
		{
			seller.updateProducts();
			opmethod();
		}
		else if(t==4)
		{
			seller.deleteProducts();
			opmethod();
		}
		else if(t==5)
		{
			sc.close();
		   return;
		}
		sc.close();
	}
	private static Scanner sc;
	static Sellers seller=new SellerImpl();
	public static void main(String[] args) throws SQLException {
		sc=new Scanner(System.in);
		
		System.out.println("ShopMe Console Application - Seller Portal");
		System.out.println("---------------------------");
		int t=0;
		defmethod();
		t=sc.nextInt();
		if(t==1)
		{
			seller.signinSeller();
		}
		
		else if(t==2)
		{
			boolean st;
			st=seller.loginSeller();
			
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
