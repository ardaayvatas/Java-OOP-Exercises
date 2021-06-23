import java.util.Locale;
import java.util.Scanner;

public class Elite extends Passenger{
	double yearRate;
	public Elite() {
		super();
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);
		System.out.println("Year Rate:");
		yearRate=sc.nextDouble();
		sc.nextLine();
	}
	public double computeExpense() {
		return (miles*mileRate)+(memberYears*yearRate);
	}
}
