import java.util.Locale;
import java.util.Scanner;

public class ElitePlus extends Passenger{
	double yearRate;
	int yearlyFixedMiles;
	public ElitePlus() {
		super();
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);
		System.out.println("Year Rate:");
		yearRate=sc.nextDouble();
		sc.nextLine();
		System.out.println("Yearly fixed miles:");
		yearlyFixedMiles=sc.nextInt();
		sc.nextLine();
	}
	public double computeExpense() {
		return (miles*mileRate)+(memberYears*yearRate)+(yearlyFixedMiles*yearRate);
	}

}
