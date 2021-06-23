public enum CheckInCounterMenu {
	C1("(1)Show Flight Information"),C2("(2)Process a Check-In."),C3("(3)Display Valid Check-Ins."),C4("(4)Switch Users"),C5("(5)Exit");
	String countermenu;
	CheckInCounterMenu(String cm){
		countermenu=cm;
	}
	String cccmenudisplay() {
		return countermenu;
	}
}
