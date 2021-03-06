package shopdb;
import java.util.*;

public class ProductBean {

	private int pro_no;
	private String code;
	private String name;
	private int price;
	private int stock;
	private String detail;
	private String comp;
	private Date reg_date;
	private String image;
	
	public ProductBean(){}

	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price; 
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}//class end
