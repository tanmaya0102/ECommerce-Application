package model;

public class CustomerDAO {

	public String Customer_ID;
	public String Customer_Name;
	public String password;

	/**
	 * @return the customer_ID
	 */
	public String getCustomer_ID() {
		return Customer_ID;
	}

	/**
	 * @param customer_ID
	 *            the customer_ID to set
	 */
	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
	}

	/**
	 * @return the customer_Name
	 */
	public String getCustomer_Name() {
		return Customer_Name;
	}

	/**
	 * @param customer_Name
	 *            the customer_Name to set
	 */
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
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
