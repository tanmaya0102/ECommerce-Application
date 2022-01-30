package main;

import java.sql.SQLException;

import impl.SellersImpl;
import interfaces.Sellers;

public class Main {
	public static void main(String[] args) {
		Sellers seller=new SellersImpl();
		try {
		      seller.loginSeller();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
