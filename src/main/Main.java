package main;

import java.sql.SQLException;

import impl.CustomerImpl;
import impl.SellerImpl;
import interfaces.Customers;
import interfaces.Sellers;

public class Main {
	public static void main(String[] args) {
		Customers customer=new CustomerImpl();
		//Sellers seller=new SellerImpl();
		try {
			  //customer.signinCustomer();
		      customer.loginCustomer();
		      customer.viewProducts();
		      //customer.addReview();
		      //customer.viewdetailProduct();
		      customer.viewCart();
		      //customer.buyProducts();
		      customer.viewProductsBought();
			  //seller.signinSeller();
			  //seller.loginSeller();
			  //seller.addProducts();
		      //seller.deleteProducts();
		      //seller.updateProducts();
			  //seller.viewProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
