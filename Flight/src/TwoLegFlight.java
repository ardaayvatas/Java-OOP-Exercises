import java.util.Locale;
import java.util.Scanner;

public class TwoLegFlight extends OneLegFlight {
	Datetime TwoLegDeparturetime;
	Datetime TwoLegArrivaltime;
	String TwoLegDestinationCity;
	int secondTimeZoneDifference;
	int secondflightDistance;
	double seconddistanceRate;
	int secondflightPrice;
	TwoLegFlight(){
		super();
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);
		System.out.println("Enter the second Departure Time;");
		TwoLegDeparturetime = new Datetime();
		System.out.println("Enter the second Arrival Time;");
		TwoLegArrivaltime = new Datetime();
		System.out.printf("Enter the second Destination City : ");
		TwoLegDestinationCity = sc.nextLine();
		System.out.printf("Enter the Time Zone Difference: ");
		secondTimeZoneDifference=sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter the second Flight Distance: ");
		secondflightDistance=sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter the second Distance Rate: ");
		seconddistanceRate=sc.nextDouble();
		sc.nextLine();
		System.out.printf("Enter the second Flight Price: ");
		secondflightPrice=sc.nextInt();
		sc.nextLine();
		System.out.println("");
	}
	@Override
	public String toStringofcities() {
		return String.format("from %s to %s ", super.getoriginCity(),TwoLegDestinationCity);
	}
	@Override
	public void displayFlightInformation() {
		System.out.println("Flight(no: "+getflightNo()+") "+toStringofcities()+" departs at "+departureTime.toString()+" and lands at \n"+TwoLegArrivaltime.toString()+" with duration of "+calculateDuration()+" hour(s)");
		System.out.println("");
	}
	@Override
	public int calculateDuration() {
		if(TwoLegArrivaltime.day==TwoLegDeparturetime.day) {
			return TwoLegArrivaltime.hour-TwoLegDeparturetime.hour+super.calculateDuration()+secondTimeZoneDifference;
		}
		else
			return ((TwoLegArrivaltime.day-TwoLegDeparturetime.day)*24)+TwoLegArrivaltime.hour-TwoLegDeparturetime.hour+super.calculateDuration()+secondTimeZoneDifference;
	}
	public double computeExpense() {
		return super.computeExpense()+secondflightPrice-(secondflightDistance*seconddistanceRate);
	}
}
