import java.util.Locale;
import java.util.Scanner;
public class ThreeLegFlight extends TwoLegFlight {
	Datetime ThreeLegDeparturetime;
	Datetime ThreeLegArrivaltime;
	String ThreeLegDestinationCity;
	int thirdTimeZoneDifference;
	int thirdflightDistance;
	double thirddistanceRate;
	int thirdflightPrice;
	ThreeLegFlight(){
		super();
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);
		System.out.println("Enter the third Departure Time;");
		ThreeLegDeparturetime = new Datetime();
		System.out.println("Enter the third Arrival Time;");
		ThreeLegArrivaltime = new Datetime();
		System.out.printf("Enter the third Destination City : ");
		ThreeLegDestinationCity = sc.nextLine();
		System.out.printf("Enter the Time Zone Difference: ");
		thirdTimeZoneDifference=sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter the Flight Distance: ");
		thirdflightDistance=sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter the Distance Rate: ");
		thirddistanceRate=sc.nextDouble();
		sc.nextLine();
		System.out.printf("Enter the Flight Price: ");
		thirdflightPrice=sc.nextInt();
		sc.nextLine();
		System.out.println("");
	}
	@Override
	public String toStringofcities() {
		return String.format("from %s to %s ", super.getoriginCity(),ThreeLegDestinationCity);
	}
	@Override
	public void displayFlightInformation() {
		System.out.println("Flight(no: "+getflightNo()+") "+toStringofcities()+" departs at "+departureTime.toString()+" and lands at \n"+ThreeLegArrivaltime.toString()+" with duration of "+calculateDuration()+" hour(s)");
		System.out.println("");
	}
	@Override
	public int calculateDuration() {
		if(ThreeLegArrivaltime.day==ThreeLegDeparturetime.day) {
			return ThreeLegArrivaltime.hour-ThreeLegDeparturetime.hour+super.calculateDuration()+thirdTimeZoneDifference;
		}
		else
			return ((ThreeLegArrivaltime.day-ThreeLegDeparturetime.day)*24)+ThreeLegArrivaltime.hour-ThreeLegDeparturetime.hour+super.calculateDuration()+thirdTimeZoneDifference;
	}
	public double computeExpense() {
		return super.computeExpense()+thirdflightPrice-(thirdflightDistance*thirddistanceRate);
	}
}
