package model;

public class SellerDAO {

	public String Seller_ID;
	public String Seller_Name;
	public String password;

	/**
	 * @return the seller_ID
	 */
	public String getSeller_ID() {
		return Seller_ID;
	}

	/**
	 * @param seller_ID
	 *            the seller_ID to set
	 */
	public void setSeller_ID(String seller_ID) {
		Seller_ID = seller_ID;
	}

	/**
	 * @return the seller_Name
	 */
	public String getSeller_Name() {
		return Seller_Name;
	}

	/**
	 * @param seller_Name
	 *            the seller_Name to set
	 */
	public void setSeller_Name(String seller_Name) {
		Seller_Name = seller_Name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
