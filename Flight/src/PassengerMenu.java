public enum PassengerMenu {
	P1("(1)Show Flight Information"),P2("(2)Buy ticket."),P3("(3)Request a Check-In."),P4("(4)Switch Users"),P5("(5)Exit");
	String passengermenu;
	PassengerMenu(String pm){
		passengermenu=pm;
	}
	String pasmenudisplay() {
		return passengermenu;
	}
}
