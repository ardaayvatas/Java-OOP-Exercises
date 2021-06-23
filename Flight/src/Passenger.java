import java.util.Locale;
import java.util.Scanner;
public abstract class Passenger extends Person {
	int miles;
	double mileRate;
	int memberYears;
	public Passenger() {
		super();
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);
		System.out.println("Miles:");
		miles=sc.nextInt();
		sc.nextLine();
		System.out.println("Member Years:");
		memberYears=sc.nextInt();
		sc.nextLine();
		System.out.println("Mile Rate:");
		mileRate=sc.nextDouble();
		sc.nextLine();
	}
	public abstract double computeExpense();
}
