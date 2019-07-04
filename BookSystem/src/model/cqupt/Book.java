package model.cqupt;

/**
 * 图书的实体
 * @author Administrator
 *
 */
public class Book {
	private String name;
	private String id;
	private String price;
	public Book( String id,String name, String price2) {
		super();
		this.id = id;
		this.name = name;
		this.price = price2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", id=" + id + ", price=" + price + "]";
	}
	
	
}
