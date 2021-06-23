import java.util.Locale;
import java.util.Scanner;
public class OneLegFlight extends Flight{
	int timeZoneDifference;
	OneLegFlight(){
		super();
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);
		System.out.printf("Enter the Time Zone Difference: ");
		timeZoneDifference=sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter the Flight Distance: ");
		flightDistance=sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter the Distance Rate: ");
		distanceRate=sc.nextDouble();
		sc.nextLine();
		System.out.printf("Enter the Flight Price: ");
		flightPrice=sc.nextInt();
		sc.nextLine();
		System.out.println("");
		
	}
	@Override
	public int calculateDuration() {
		return super.calculateDuration()+timeZoneDifference;
	}
	public double computeExpense() {
		return flightPrice-(flightDistance*distanceRate);
	}
}
