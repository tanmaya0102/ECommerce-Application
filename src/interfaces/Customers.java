package interfaces;

import java.sql.SQLException;

public interface Customers {

	public void signinCustomer() throws SQLException;

	public boolean loginCustomer() throws SQLException;
	
	public void viewProducts() throws SQLException;
	
	public void viewdetailProduct() throws SQLException;
	
	public void addtoCart() throws SQLException;
	
	public void viewCart() throws SQLException;
	
	public void addReview() throws SQLException;
	
	public void buyProducts() throws SQLException;
	
	public void viewProductsBought() throws SQLException;
	
	

}
