package interfaces;

import java.sql.SQLException;

public interface Sellers {
	
	public  void signinSeller() throws SQLException;
	
	public boolean loginSeller() throws SQLException;
	
	public void addProducts() throws SQLException;
	
	public void deleteProducts() throws SQLException;
	
	public void updateProducts() throws SQLException;
	
	public void viewProducts() throws SQLException;
	
}
