public enum MainMenu {
	M1("(1)Add a Staff"),M2("(2)Add a Passenger"),M3("(3)Staff Login"),M4("(4)Passenger Login"),M5("(5)Exit");
	String mainmenu;
	MainMenu(String mm){
		mainmenu=mm;
	}
	String mmmenudisplay() {
		return mainmenu;
	}
}
