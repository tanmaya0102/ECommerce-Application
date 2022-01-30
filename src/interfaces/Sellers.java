package interfaces;

import java.sql.SQLException;

public interface Sellers {
	
	public  void signinSeller() throws SQLException;
	
	public boolean loginSeller() throws SQLException;
	
	public void addProducts();
	
	public void deleteProducts();
	
	public void updateProducts();
	
}
