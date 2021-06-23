import java.util.Scanner;
import javax.swing.JOptionPane;

public class Product implements Payable{
    public int id;	
	private String brand;
	private String model;
	private int stock;
	private String isShippingFree;
	static int productCount = 0;
	String str;
	Scanner sc = new Scanner(System.in);
	CategoryForProducts category;
	public Product(){
		str = JOptionPane.showInputDialog("ID:");
		//System.out.printf("%s\n", "ID:");
		//str= sc.nextLine();	
		//System.out.printf("%s\n", "ID:");
		//str= sc.nextLine();
		setId(Integer.parseInt(str));
		str = JOptionPane.showInputDialog("Brand:");
		//System.out.printf("%s\n", "Brand:");
		setBrand(str);
		//System.out.printf("%s\n", "Model:");
		str = JOptionPane.showInputDialog("Model:");
		setModel(str);
		//System.out.printf("%s\n", "Free Shipping(y/n):");
		str = JOptionPane.showInputDialog("Free Shipping(y/n):");
		setShipping(str);
		str = JOptionPane.showInputDialog("Stock:");
		//System.out.printf("%s\n", "Stock:");
		setStock(Integer.parseInt(str));
		productCount++;
		category=CategoryForProducts.SERVICE;
	}

	void displayProductInfo(){
		JOptionPane.showMessageDialog(null,"id:"+id+"\n"+"brand:"+brand+"\n"+"model:"+model+"\n"+"stock:"+stock+"\n"+"category:"+category+" with starting price of "+category.getPrice()+"\n"+"shipping:"+isShippingFree+"\n","Display Product Info",JOptionPane.INFORMATION_MESSAGE);
		/*System.out.println("id:"+id+"\n"+ 
				"brand:"+brand+"\n"+
				"model:"+model+"\n"+
				"stock:"+stock+"\n"+
				"category:"+category+" with starting price of "+category.getPrice()+"\n"+
				"shipping:"+isShippingFree+"\n");*/
	}

	public void setId(int Id)
	{
		this.id = Id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setStock(int Stock)
	{ 
		this.stock = Stock;
	}
	
	public int getStock()
	{
		return this.stock;
	}
	
	public void setBrand(String Brand)
	{
		this.brand = Brand;
	}
	
	public String getBrand()
	{
		return this.brand;
	}
	
	public void setModel(String Model)
	{
		this.model = Model;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public void setShipping(String shipping)
	{
		this.isShippingFree = shipping;
	}
	
	public String getShipping()
	{
		return this.isShippingFree;
	}
	public Product(CategoryForProducts cat){
		this();	
		this.category = cat;
	}
	public double calculatePayment() {
		double productpay=0;
		if(category.getPrice()== "$1000") {
			productpay=1000;
		}
		else if(category.getPrice()== "$500") {
			productpay=500;
		}
		else if(category.getPrice()== "$100") {
			productpay=100;
		}
		else if(category.getPrice()== "$200") {
			productpay=200;
		}
		else if(category.getPrice()== "$20") {
			productpay=20;
		}
		if(isShippingFree.equals("n")) {
			productpay=productpay+10;
		}
		return productpay;
	}
}
