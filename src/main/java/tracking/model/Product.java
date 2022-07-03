package tracking.model;

public class Product {
	private int id;
	private Category category;
	private String name;
	private String price;
	private int rate;
	private int sold;
	private String image;
	private int discount;
	private String discountPrice;

	public Product() {
	}

	public Product(int id, Category category, String name, String price, int rate, int sold, String image, int discount, String discountPrice) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.rate = rate;
		this.sold = sold;
		this.image = image;
		this.discount = discount;
		this.discountPrice = discountPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}
}
