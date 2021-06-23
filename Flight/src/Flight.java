import java.util.Scanner;
import java.util.InputMismatchException;
public abstract class Flight implements Expense,Comparable<Flight>{
	int flightNo;
	Datetime departureTime;
	Datetime arrivalTime;
	String originCity;
	String destinationCity;
	int maxLoadOfPlane;
	int flightDistance;
	double distanceRate;
	int flightPrice;
	boolean loopcontinueforflightno=true;
	boolean loopcontinueformaxLoadOfPlane=true;
	public Flight(){
		Scanner sc=new Scanner(System.in);
		System.out.println();
		//System.out.printf("Enter the flight no: ");
		do {
			try {
				System.out.printf("Enter the flight no: ");
				flightNo=sc.nextInt();
				sc.nextLine();
				loopcontinueforflightno=false;
			}
			catch(InputMismatchException inputMismatchException) {
				System.err.println("Flight no cannot be a String");
				sc.nextLine();
			}
		}while(loopcontinueforflightno);
		//flightNo=sc.nextInt();
		//sc.nextLine();
		System.out.printf("Enter the Departure Time;");
		System.out.println();
		departureTime= new Datetime();
		System.out.printf("Enter the Arrival Time;");
		System.out.println();
		arrivalTime= new Datetime();
		System.out.printf("Enter the Origin City: ");
		originCity=sc.nextLine();
		System.out.printf("Enter the Destination City: ");
		destinationCity=sc.nextLine();
		do {
			try {
				System.out.printf("Enter the Max Load: ");
				maxLoadOfPlane=sc.nextInt();
				sc.nextLine();
				loopcontinueformaxLoadOfPlane=false;
			}
			catch(InputMismatchException inputMismatchException) {
				System.err.println("Max Load cannot be a String");
				sc.nextLine();
			}
		}while(loopcontinueformaxLoadOfPlane);
		//System.out.printf("Enter the Max Load: ");
		//maxLoadOfPlane=sc.nextInt();
		//sc.nextLine();
	}
	public int getflightNo() {
		return flightNo;
	}
	public String getoriginCity() {
		return originCity;
	}
	public void displayFlightInformation() {
		System.out.println("Flight(no: "+flightNo+") "+"from "+originCity+" to "+destinationCity+" departs at "+departureTime.toString()+" and lands at \n"+arrivalTime.toString()+" with duration of "+calculateDuration()+" hour(s)");
		System.out.println();
	}
	public String getdestinationCity() {
		return destinationCity;
	}
	public String toStringofcities() {
		return "from" +originCity+" to "+destinationCity;
	}
	public int calculateDuration() {
		if(arrivalTime.day==departureTime.day) {
			return arrivalTime.hour-departureTime.hour;
		}
		else
			return ((arrivalTime.day-departureTime.day)*24)+arrivalTime.hour-departureTime.hour;
	}
	public abstract double computeExpense();
	public int compareTo(Flight fl) {
		int startdateyeartomonth,flstartdateyeartomonth,startdateextra,flstartdateextra;
		startdateyeartomonth=(departureTime.year*12)+departureTime.month;
		flstartdateyeartomonth=(fl.departureTime.year*12)+fl.departureTime.month;
		startdateextra=(departureTime.day*24*60)+(departureTime.hour*60)+departureTime.minute;
		flstartdateextra=(fl.departureTime.day*24*60)+(fl.departureTime.hour*60)+fl.departureTime.minute;
		if(startdateyeartomonth==flstartdateyeartomonth) {
			if(startdateextra==flstartdateextra)
				return 0;
			else if(startdateextra>flstartdateextra)
				return 1;
			else
				return 0;
		}
		else if(startdateyeartomonth>flstartdateyeartomonth) {
			return 1;
		}
		else
			return -1;
	}
}