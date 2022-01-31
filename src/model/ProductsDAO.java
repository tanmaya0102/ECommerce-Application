package model;

public class ProductsDAO {
	public String Product_ID;
	public String Seller_ID;
	public String Product_Name;
	public String Product_Description;
	public float Price;
	public int Quantity;
	public boolean Status;

	/**
	 * @return the product_ID
	 */
	public String getProduct_ID() {
		return Product_ID;
	}

	/**
	 * @param product_ID
	 *            the product_ID to set
	 */
	public void setProduct_ID(String product_ID) {
		Product_ID = product_ID;
	}

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
	 * @return the product_Name
	 */
	public String getProduct_Name() {
		return Product_Name;
	}

	/**
	 * @param product_Name
	 *            the product_Name to set
	 */
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	/**
	 * @return the product_Description
	 */
	public String getProduct_Description() {
		return Product_Description;
	}

	/**
	 * @param product_Description
	 *            the product_Description to set
	 */
	public void setProduct_Description(String product_Description) {
		Product_Description = product_Description;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return Price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		Price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return Quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return Status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		Status = status;
	}

}
