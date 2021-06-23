
public enum CategoryForProducts {
	COMPUTER("$1000"), MOBILE("$500"), WEARABLE("$100"), SMARTHOME("$200"), SERVICE("$20");
	
	private String price;
	CategoryForProducts(String p){
		price= p;
	}
	String getPrice() {
		return price;
	}
}
