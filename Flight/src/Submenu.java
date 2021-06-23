public enum Submenu {
	AA("(1)Create non-stop flight."),BB("(2)Create a two-leg flight."),CC("(3)Create a three-leg flight.");
	String subchoicee;
	Submenu(String y){
		subchoicee=y;
	}
	String submenudisplay() {
		return subchoicee;
	}
}