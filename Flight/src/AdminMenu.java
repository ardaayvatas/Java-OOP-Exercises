public enum AdminMenu {
	A1("(1)Add a New Flight"),A2("(2)Show Flight Information"),A3("(3)Calculate Take-Off Load"),A4("(4)Calculate Expenses"),A5("(5)Switch Users"),A6("(6)Exit.");
	String adminmenu;
	AdminMenu(String ad){
		adminmenu=ad;
	}
	String admenudisplay() {
		return adminmenu;
	}
}
